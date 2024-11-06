package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize;

    public SizeCalculatorVisitor() {
        totalSize = 0;
    }

    public void visit(File file) {
        totalSize += file.getSize();
    }

    public int getTotalSize() {
        return totalSize;
    }


}
