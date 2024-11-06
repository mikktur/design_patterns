package proxy;


import java.util.HashMap;

public class AccesControlService {
    //singleton
    private static AccesControlService instance = null;
    private static final HashMap<Integer, String> accessControlList = new HashMap<>();
    private AccesControlService() {
    }

    public static synchronized AccesControlService getInstance() {
        if (instance == null) {
            instance = new AccesControlService();
        }
        return instance;
    }
    public void addPermission(int documentId, String username) {
        accessControlList.put(documentId, username);
    }

    public static void isAllowed(String userName, int documentId)throws AccessDeniedException {
        if (accessControlList.containsKey(documentId)) {
            if (!accessControlList.get(documentId).equals(userName)) {
                throw new AccessDeniedException();
            }
        } else {
            System.out.println("This should never happen");
            throw new AccessDeniedException();
        }


    }



}
