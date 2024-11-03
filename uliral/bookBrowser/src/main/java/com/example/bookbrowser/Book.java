package com.example.bookbrowser;

import javafx.beans.property.*;

public class Book {
    private IntegerProperty id;
    private StringProperty title;
    private StringProperty type;
    private StringProperty  au_fname;
    private StringProperty  year;
    private StringProperty  titleNotes;
    private IntegerProperty  sales;
    private FloatProperty price;
    private IntegerProperty  royalty;
    private FloatProperty advance;
    private StringProperty pub_name;

    public Book( String  Title, String Type, String  Year, String  TitleNotes, Integer  Sales, float Price, Integer Royalty, float Advance){
        this.title=new SimpleStringProperty(Title);
        this.type=new SimpleStringProperty(Type);
        this.year=new SimpleStringProperty(Year);
        this.titleNotes=new SimpleStringProperty(TitleNotes);
        this.sales=new SimpleIntegerProperty(Sales);
        this.price=new SimpleFloatProperty(Price);
        this.royalty=new SimpleIntegerProperty(Royalty);
        this.advance=new SimpleFloatProperty(Advance);
    }

    public Book(String  Pub_name, String au_fname, String  Title){
        this.pub_name = new SimpleStringProperty(Pub_name);
        this.au_fname = new SimpleStringProperty(au_fname);
        this.title=new SimpleStringProperty(Title);

    }


    public IntegerProperty idProperty() {
        return id;
    }
    public Integer getId() {
        return id.get();
    }


    public StringProperty getTitleProperty() {
        return title;
    }
    public String getTitle() {
        return title.get();
    }


    public StringProperty getTypeProperty() {
        return type;
    }
    public String getType() {
        return type.get();
    }


    public StringProperty getAu_fnameProperty() {
        return au_fname;
    }
    public String getAu_fname() {
        return au_fname.get();
    }


    public StringProperty getYearProperty() {
        return year;
    }
    public String getYear() {
        return year.get();
    }


    public StringProperty getTitleNotesProperty() {
        return titleNotes;
    }
    public String getTitleNotes() {
        return titleNotes.get();
    }


    public IntegerProperty getSalesProperty() {
        return sales;
    }
    public Integer getSales() {
        return sales.get();
    }


    public FloatProperty getPriceProperty() {
        return price;
    }
    public Float getPrice() {
        return price.get();
    }


    public IntegerProperty getRoyaltyProperty() {
        return royalty;
    }
    public Integer getRoyalty() {
        return royalty.get();
    }

    public FloatProperty getAdvanceProperty() {
        return advance;
    }
    public Float getAdvance() {
        return advance.get();
    }

    public StringProperty getPub_nameProperty() {
        return pub_name;
    }
    public String getPub_name() {
        return pub_name.get();
    }


}