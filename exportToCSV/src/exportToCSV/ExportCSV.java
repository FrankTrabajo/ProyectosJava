package exportToCSV;

import java.io.StringWriter;

public class ExportCSV {

    public String guardarTabla(String[][] tablaDatos) {
        // Generar la cadena CSV
        StringWriter csvWriter = new StringWriter();
        for (String[] fila : tablaDatos) {
            for (int i = 0; i < fila.length; i++) {
                csvWriter.append(fila[i]);
                if (i < fila.length - 1) {
                    csvWriter.append(',');
                }
            }
            csvWriter.append('\n');
        }

        // Devolver la cadena CSV como respuesta
        return csvWriter.toString();
    }
}
