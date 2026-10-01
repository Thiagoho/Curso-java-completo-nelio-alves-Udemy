package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

/*Acabamos de estudar as funções 
 * BufferedReader, 
 * FileReader,
 * BufferedWriter
 * FileWriter */
public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter file path: ");
        String strFile = sc.nextLine();

        // Representa o arquivo informado pelo usuário
        File sourceFile = new File(strFile);

        // Pega somente a pasta onde o arquivo está
        String sourceFolderStr = sourceFile.getParent();

        // Cria a pasta "out"
        File outFolder = new File(sourceFolderStr + "\\out");

        boolean success = outFolder.mkdir();

       // System.out.println("Directory created: " + success);

        // Caminho do arquivo que será criado
        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        // Leitura do arquivo CSV
        try (BufferedReader br =
                     new BufferedReader(new FileReader(sourceFile))) {

            String itemCsv = br.readLine();

            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");

                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                Product product =
                        new Product(name, price, quantity);

                list.add(product);

                itemCsv = br.readLine();
            }

            // Escrita do novo arquivo
            try (BufferedWriter bw =
                         new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : list) {

                    bw.write(
                        item.getName()
                        + ","
                        + String.format("%.2f", item.valorTotal())
                    );

                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");

            } catch (IOException e) {

                System.out.println(
                    "Error writing file: " + e.getMessage()
                );
            }

        } catch (IOException e) {

            System.out.println(
                "Error reading file: " + e.getMessage()
            );
        }

        sc.close();
    }
}