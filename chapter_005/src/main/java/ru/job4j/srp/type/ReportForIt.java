package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;

import java.util.List;

public class ReportForIt implements TypeCreator {

    public String createByType(List<Employe> employes, String type) {
        switch (type.toLowerCase()) {
            case "html":
                return htmlReport(employes);
            case "json":
                return jsonReport(employes);
            case "xml":
                return xmlReport(employes);
            default:
                return null;
        }
    }

    private String htmlReport(List<Employe> employes) {
        StringBuilder result = new StringBuilder();
        result.append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title>").append("Report").append("</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th>").append("Name").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Hired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Fired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Salary").append("</th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (Employe employe : employes) {
            result.append("<tr>").append(System.lineSeparator())
                    .append("<td>").append(employe.getName()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employe.getHired().getTime()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employe.getFired().getTime()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employe.getSalary()).append("</td>").append(System.lineSeparator())
                    .append("</tr>").append(System.lineSeparator());
        }
        result.append("</table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return result.toString();
    }

    private String xmlReport(List<Employe> employes) {
        StringBuilder result = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(System.lineSeparator())
                .append("<employers>").append(System.lineSeparator());
        for (Employe employe : employes) {
            result.append("<employer>").append(System.lineSeparator())
                    .append("<name>").append(employe.getName()).append("</name>").append(System.lineSeparator())
                    .append("<hired>").append(employe.getHired().getTime()).append("</hired>").append(System.lineSeparator())
                    .append("<fired>").append(employe.getFired().getTime()).append("</fired>").append(System.lineSeparator())
                    .append("<salary>").append(employe.getSalary()).append("</salary>").append(System.lineSeparator())
                    .append("</employer>").append(System.lineSeparator());
        }
        result.append("</employers>").append(System.lineSeparator());
        return result.toString();
    }

    private String jsonReport(List<Employe> employes) {
        StringBuilder text = new StringBuilder();
        for (Employe employe : employes) {
            text.append("{").append(System.lineSeparator())
                    .append("\"name\": ").append("\"").append(employe.getName()).append("\",").append(System.lineSeparator())
                    .append("\"hired\": ").append(employe.getHired().getTime()).append(",").append(System.lineSeparator())
                    .append("\"fired\": ").append(employe.getFired().getTime()).append(",").append(System.lineSeparator())
                    .append("\"salary\": ").append(employe.getSalary()).append(",").append(System.lineSeparator())
                    .append("}").append(System.lineSeparator());
        }
        return text.toString();
    }

}
