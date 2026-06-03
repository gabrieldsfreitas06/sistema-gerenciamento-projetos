package view;

import java.util.Scanner;

public class MenuPrincipal {

    public static int exibirMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== SISTEMA DE GESTÃO DE PROJETOS =====");

        System.out.println("1 - Administrador");
        System.out.println("2 - Gerente de Projeto");
        System.out.println("3 - Colaborador");
        System.out.println("0 - Sair");

        System.out.print("Escolha: ");

        return sc.nextInt();
    }
}