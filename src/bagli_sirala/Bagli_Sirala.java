package bagli_sirala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bagli_Sirala {

    public static void main(String[] args) {
        BufferedReader reader = null;
        List<Node> nodes = new ArrayList<>();
        List<Node> sortedNodes = new ArrayList<>();
        List<Node> copyNode = new ArrayList<>();

        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Dosya adını girin: ");
            String dosyaAdi = br.readLine();

            reader = new BufferedReader(new FileReader(dosyaAdi));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                int data = Integer.parseInt(line);
                nodes.add(new Node(data, index));
                copyNode.add(new Node(data, index));
                index++;
            }

            sortedNodes.addAll(nodes);
            selectionSort(sortedNodes);

            System.out.println("İlk Hali\t\t\tSıralanmış Hali");
            System.out.println("Data\tAdres\t\t\tData\tAdres");
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                Node copy = copyNode.get(i);
                System.out.println(copy.data + "\t" + copy.adres + "\t\t\t" + node.data + "\t" + node.adres);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void selectionSort(List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j).data < nodes.get(minIndex).data) {
                    minIndex = j;
                }
            }
            int tempAddress = nodes.get(minIndex).adres;
            nodes.get(minIndex).adres = nodes.get(i).adres;
            nodes.get(i).adres = tempAddress;

            Node temp = nodes.get(minIndex);
            nodes.set(minIndex, nodes.get(i));
            nodes.set(i, temp);
        }
    }
}
