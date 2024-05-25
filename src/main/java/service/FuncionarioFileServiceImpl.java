package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import model.Funcionario;
import repository.FuncionarioRepository;

@ApplicationScoped
public class FuncionarioFileServiceImpl implements FileService {

    // Caminho de exemplo: \Users\athos\.vscode\ecommerce-sapato\imagens\funcionario
    private final String PATH_USER = System.getProperty("user.home")
        + File.separator + ".vscode"
        + File.separator + "ecommerce-sapato"
        + File.separator + "imagens"
        + File.separator + "funcionario" + File.separator;

    @Inject 
    FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        if (funcionario == null) {
            throw new ValidationException("Funcionário não encontrado para o ID: " + id);
        }

        try {
            String nomeArquivo = salvarImagem(nomeImagem, imagem);
            funcionario.setNomeImagem(nomeArquivo);
        } catch (IOException e) {
            throw new ValidationException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    private String salvarImagem(String nomeImagem, byte[] imagem) throws IOException {
        // Verificar o tipo da imagem através da extensão do nome do arquivo
        String extension = nomeImagem.substring(nomeImagem.lastIndexOf(".") + 1);
        List<String> extensoesSuportadas = Arrays.asList("jpg", "gif", "png", "jpeg");
        if (!extensoesSuportadas.contains(extension.toLowerCase())) {
            throw new IOException("Tipo de imagem não suportada");
        }

        // Verificar o tamanho do arquivo - não permitir maior que 10MB
        if (imagem.length > 1024 * 1024 * 10) {
            throw new IOException("Arquivo muito grande, tamanho não suportado");
        }

        // Criar pasta se não existir
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        // Gerar nome do arquivo
        String nomeArquivo = UUID.randomUUID() + "." + extension;
        String caminhoCompleto = PATH_USER + nomeArquivo;

        // Verificar se o arquivo já existe
        File file = new File(caminhoCompleto);
        if (file.exists()) {
            throw new IOException("Este arquivo já existe");
        }

        // Criar e salvar o arquivo no sistema de arquivos
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(imagem);
        }

        return nomeArquivo;
    }

    @Override
    public File download(String nomeImagem) {
        return new File(PATH_USER + nomeImagem);
    }
}
