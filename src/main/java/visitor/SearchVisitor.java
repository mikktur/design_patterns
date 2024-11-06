package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchName;
    private List<File> foundFiles = new ArrayList<>();
    public SearchVisitor(String searchName) {
        this.searchName = searchName;
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }

    //used inside visited elements to add the found file to the list
    @Override
    public void visit(File file) {
        if (file.getName().contains(searchName)) {
            foundFiles.add(file);
        }
    }

}
