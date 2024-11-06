package visitor;

public class File implements FileSystemElement {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void accept(FileSystemVisitor visitor) {
        //triggers the visit method of the visitor(adds the file to the list of found files or calculates the total size)
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }


}
