package dev.groupeighteen.librarydatabasesystem.application.model.item;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/2/2023
 */
public abstract class Item {

    public Item() {
    }

    /*
    public void updateItemStatus(int itemID, String newStatus) {
        String updateSQL = "UPDATE Item SET Item_Status = ? WHERE Item_ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, itemID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
