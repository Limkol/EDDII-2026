import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FrequenciaPalavras {

    private static final String ARQUIVO_PADRAO = "texto.txt";

    public static void main(String[] args) {
        String caminho = args.length > 0 ? args[0] : ARQUIVO_PADRAO;

        String texto;
        try {
            texto = Files.readString(Path.of(caminho), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Nao foi possivel ler o arquivo: " + caminho);
            return;
        }

        Map<String, Integer> frequencias = new LinkedHashMap<>();

        for (String palavra : texto.toLowerCase().split("[^\\p{L}\\p{N}]+")) {
            if (!palavra.isEmpty()) {
                frequencias.merge(palavra, 1, Integer::sum);
            }
        }

        List<Map.Entry<String, Integer>> ordenadas = new ArrayList<>(frequencias.entrySet());
        ordenadas.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (var e : ordenadas) {
            System.out.println(e.getKey() + " (" + e.getValue() + ")");
        }
    }
}