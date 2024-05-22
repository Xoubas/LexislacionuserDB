package org.example.dao;

import org.example.connection.JPAUtil;
import org.example.model.Norma;

import java.util.List;
import java.util.Scanner;

public class AppConsultas {
    public static void main(String[] args) {
        NormaDAO normaDAO = new NormaDAO(JPAUtil.LEXISLACIONPOSTGRES);
        NormaPaginacion normaPaginacion = new NormaPaginacion(normaDAO, 10);
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            List<Norma> normas = normaPaginacion.getPageContent();
            System.out.println("Page " + normaPaginacion.getCurrentPage() + " of " + normaPaginacion.getTotalPages());
            for (Norma n : normas) {
                System.out.println(n);
            }

            System.out.println("'n' siguiente página, 'p' página anterior, 'q' para salir.");
            command = scanner.nextLine();

            if (command.equals("n")) {
                normaPaginacion.nextPage();
            } else if (command.equals("p")) {
                normaPaginacion.previousPage();
            }
        } while (!command.equals("q"));

//        normaPaginacion.close();
    }
}
