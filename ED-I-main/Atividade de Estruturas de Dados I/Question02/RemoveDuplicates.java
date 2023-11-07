public class RemoveDuplicates {
    public static void main(String[] args) {
        LDE list = new LDE();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        list.insert(4);
        list.insert(2);
        list.insert(5);
        
        int valueToRemove = 2;
        int removedCount = list.remove(valueToRemove);
        
        System.out.println("Lista após a remoção das ocorrências de " + valueToRemove + ":");
        list.display();
        System.out.println("Total de ocorrências removidas: " + removedCount);
    }
}