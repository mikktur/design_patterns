package visitor;

public class Main {
    public static void main(String[] args) {
        // Create a sample file system structure
        Directory root = new Directory("root");
        Directory folder1 = new Directory("folder1");
        Directory folder2 = new Directory("folder2");
        Directory folder3 = new Directory("folder3");
        File file1 = new File("report1.log", 5);
        File file2 = new File("notes.txt", 3);
        File file3 = new File("report2.txt", 7);
        File file4 = new File("report3.log", 1);
        File file5 = new File("report4.txt", 2);
        File file6 = new File("report5.log", 3);

        // Build the hierarchy
        root.addChild(folder1);
        root.addChild(folder2);
        folder2.addChild(folder3);
        folder1.addChild(file1);
        folder1.addChild(file2);
        folder2.addChild(file3);
        folder2.addChild(file4);
        folder3.addChild(file5);
        folder2.addChild(file6);

        // Test SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".txt");

        //visitor starts traversing from the root untill it has scanned all the files
        root.accept(searchVisitor);
        System.out.println("Search results for 'report':");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("Found file: " + file.getName());
        }

        // Test SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of files: " + sizeVisitor.getTotalSize() + " megabytes");
    }
}