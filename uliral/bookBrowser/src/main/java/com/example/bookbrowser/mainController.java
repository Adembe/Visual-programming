package com.example.bookbrowser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private TextField advanceField;

    @FXML
    private TableColumn<Book, String> authorCol;
    @FXML
    private TableColumn<Book, String> pubNameCol;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableView<Book> testTable;


    @FXML
    private TreeView<Book> authorTree;
    TreeItem root = new TreeItem<>("root");

    @FXML
    private TextField datField;

    @FXML
    private Button findBtn;

    @FXML
    private TextField findField;

    @FXML
    private TextField notesField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField royaltyField;

    @FXML
    private TextField salesField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField typeField;


    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library1","root","");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Book> getAuthorList(){
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT publishers.pub_id, publishers.pub_name, authors.au_lname, authors.au_fname, titles.title, publishers.city AS pub_city, publishers.state AS pub_state, publishers.country AS pub_country, titles.title_id, titles.type AS title_type, titles.price AS title_price, titles.advance AS title_advance, titles.royalty AS title_royalty, titles.ytd_sales AS title_ytd_sales, titles.notes AS title_notes, titles.pubdate AS title_pubdate, titles.imagePath AS title_imagePath, authors.aud_id, authors.phone AS au_phone, authors.address AS au_address, authors.city AS au_city, authors.state AS au_state, authors.zip AS au_zip FROM (titles INNER JOIN publishers ON titles.pub_id = publishers.pub_id) INNER JOIN (authors INNER JOIN titleauthor ON authors.aud_id = titleauthor.aud_id) ON titles.title_id = titleauthor.title_id ORDER BY publishers.pub_id, authors.au_lname, authors.au_fname, titles.title_id;";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Book book;
            while(rs.next()) {
                book = new Book(rs.getString("pub_name"),rs.getString("au_fname"),rs.getString("title"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public ObservableList<Book> getTitleList(){
        ObservableList<Book> bookList1 = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT publishers.pub_id, publishers.pub_name, publishers.city AS pub_city,  publishers.state AS pub_state, titles.title_id, titles.title, titles.type AS title_type, titles.price AS title_price, titles.advance AS title_advance, titles.royalty AS title_royalty, titles.ytd_sales AS title_ytd_sales, titles.notes AS title_notes, titles.pubdate AS title_pubdate, titles.imagePath AS title_imagePath FROM titles  INNER JOIN publishers ON titles.pub_id = publishers.pub_id ORDER BY publishers.pub_id, titles.title_id;";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Book book1;
            while(rs.next()) {
                book1 = new Book(rs.getString("title"), rs.getString("title_type"),rs.getString("title_pubdate"),rs.getString("title_notes"),rs.getInt("title_ytd_sales"),rs.getFloat("title_price"),rs.getInt("title_royalty"),rs.getFloat("title_advance"));
                bookList1.add(book1);
                String type = rs.getString("title_type");
                typeField.setText(type);
                String notes =rs.getString("title_notes");
                notesField.setText(notes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList1;
    }
    public void showTitles() {
        ObservableList<Book> list = getTitleList();



    }

    public void showAuthors() {
        ObservableList<Book> list = getAuthorList();
        pubNameCol.setCellValueFactory(new PropertyValueFactory<Book,String>("pub_name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book,String>("au_fname"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        testTable.setItems(list);

//        TreeItem<String> rootItem = new TreeItem<String> ("books");
//        rootItem.setExpanded(true);
//        TreeItem<String> publisher = new TreeItem<String>("pub_name");
//        TreeItem<String> author = new TreeItem<String>("au_fname");
//        TreeItem<String> titleItem = new TreeItem<String>("title");
//        author.getChildren().add(titleItem);
//        publisher.getChildren().add(author);
//
//        rootItem.getChildren().add(publisher);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        testTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book oldbook, Book newbook) {
                if(newbook != null) {

                    titleField.setText(newbook.getTitle() + "");

                    getTitleList();
                    System.out.println(newbook);
                }
            }
        });

        showAuthors();

    }

}
