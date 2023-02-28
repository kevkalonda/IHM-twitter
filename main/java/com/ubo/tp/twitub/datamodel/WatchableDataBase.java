package main.java.com.ubo.tp.twitub.datamodel;

public class WatchableDataBase implements IDatabaseObserver {

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        System.out.println("Twit added successfully");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        System.out.println("Twit deleted successfully");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        System.out.println("Twit modified successfully");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyUserAdded(User addedUser) {
        System.out.println("User added successfully");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyUserDeleted(User deletedUser) {
        System.out.println("User deleted successfully");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyUserModified(User modifiedUser) {
        System.out.println("User modified successfully");
    }
}
