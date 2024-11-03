package com.example.lab10;

import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SonguuliGUI extends GridPane {

    //------------------LABELS----------------------------
    private final Label arkhangaiTotal = new Label("/5000");
    private final Label arkhangaiVotes = new Label("0");
    private final Label arkhangaiProgress = new Label("");

    private final Label bayanUlgiiTotal = new Label("/5000");
    private final Label bayanUlgiiVotes = new Label("0");
    private final Label bayanUlgiiProgress = new Label("");

    private final Label bayanhongorTotal = new Label("/5000");
    private final Label bayanhongorVotes = new Label("0");
    private final Label bayanhongorProgress = new Label("");

    private final Label bulganTotal = new Label("/5000");
    private final Label bulganVotes = new Label("0");
    private final Label bulganProgress = new Label("");

    private final Label goviAltaiTotal = new Label("/5000");
    private final Label goviAltaiVotes = new Label("0");
    private final Label goviAltaiProgress = new Label("");

    private final Label govisumberTotal = new Label("/5000");
    private final Label govisumberVotes = new Label("0");
    private final Label govisumberProgress = new Label("");

    private final Label darhanUulTotal = new Label("/5000");
    private final Label darhanUulVotes = new Label("0");
    private final Label darhanUulProgress = new Label("");

    private final Label dornogoviTotal = new Label("/5000");
    private final Label dornogoviVotes = new Label("0");
    private final Label dornogoviProgress = new Label("");

    private final Label dornodTotal = new Label("/5000");
    private final Label dornodVotes = new Label("0");
    private final Label dornodProgress = new Label("");

    private final Label dundgoviTotal = new Label("/5000");
    private final Label dundgoviVotes = new Label("0");
    private final Label dundgoviProgress = new Label("");

    private final Label zavhanTotal = new Label("/5000");
    private final Label zavhanVotes = new Label("0");
    private final Label zavhanProgress = new Label("");

    private final Label orhonTotal = new Label("/5000");
    private final Label orhonVotes = new Label("0");
    private final Label orhonProgress = new Label("");

    private final Label uvurhangaiTotal = new Label("/5000");
    private final Label uvurhangaiVotes = new Label("0");
    private final Label uvurhangaiProgress = new Label("");

    private final Label umnugoviTotal = new Label("/5000");
    private final Label umnugoviVotes = new Label("0");
    private final Label umnugoviProgress = new Label("");

    private final Label suhbaatarTotal = new Label("/5000");
    private final Label suhbaatarVotes = new Label("0");
    private final Label suhbaatarProgress = new Label("");

    private final Label selengeTotal = new Label("/5000");
    private final Label selengeVotes = new Label("0");
    private final Label selengeProgress = new Label("");

    private final Label tuvTotal = new Label("/5000");
    private final Label tuvVotes = new Label("0");
    private final Label tuvProgress = new Label("");

    private final Label uvsTotal = new Label("/5000");
    private final Label uvsVotes = new Label("0");
    private final Label uvsProgress = new Label("");

    private final Label hovdTotal = new Label("/5000");
    private final Label hovdVotes = new Label("0");
    private final Label hovdProgress = new Label("");

    private final Label huvsgulTotal = new Label("/5000");
    private final Label huvsgulVotes = new Label("0");
    private final Label huvsgulProgress = new Label("");

    private final Label hentiiTotal = new Label("/5000");
    private final Label hentiiVotes = new Label("0");
    private final Label hentiiProgress = new Label("");

    private final Label ubTotal = new Label("/5000");
    private final Label ubVotes = new Label("0");
    private final Label ubProgress = new Label("");

    //------------------PROGRESSBAR----------------------------

    private final ProgressBar arkhangaiProgressBar = new ProgressBar();
    private final ProgressBar bayanUlgiiProgressBar = new ProgressBar();
    private final ProgressBar bayanhongorProgressBar = new ProgressBar();
    private final ProgressBar bulganProgressBar = new ProgressBar();
    private final ProgressBar goviAltaiProgressBar = new ProgressBar();
    private final ProgressBar govisumberProgressBar = new ProgressBar();
    private final ProgressBar darhanUulProgressBar = new ProgressBar();
    private final ProgressBar dornogoviProgressBar = new ProgressBar();
    private final ProgressBar dornodProgressBar = new ProgressBar();
    private final ProgressBar dundgoviProgressBar = new ProgressBar();
    private final ProgressBar zavhanProgressBar = new ProgressBar();
    private final ProgressBar orhonProgressBar = new ProgressBar();
    private final ProgressBar uvurhangaiProgressBar = new ProgressBar();
    private final ProgressBar umnugoviProgressBar = new ProgressBar();
    private final ProgressBar suhbaatarProgressBar = new ProgressBar();
    private final ProgressBar selengeProgressBar = new ProgressBar();
    private final ProgressBar tuvProgressBar = new ProgressBar();
    private final ProgressBar uvsProgressBar = new ProgressBar();
    private final ProgressBar hovdProgressBar = new ProgressBar();
    private final ProgressBar huvsgulProgressBar = new ProgressBar();
    private final ProgressBar hentiiProgressBar = new ProgressBar();
    private final ProgressBar ubProgressBar = new ProgressBar();

    public SonguuliGUI()
    {
        addGUI();

//        int boxCount[] = new int[22];
//        for (int i = 0; i < boxCount.length; i++) {
//            boxCount[i] = (int) (Math.random() * 50000);
//        }
    }

    public SonguuliGUI(Worker<ObservableList<Integer>> worker)
    {
        addGUI();
        bindToWorker(worker);
    }

    private void addGUI(){
        this.setHgap(30);
        this.setVgap(10);

        addRow(0, new Label("Архангай:"), new HBox(arkhangaiProgressBar, arkhangaiProgress),  new HBox(arkhangaiVotes,arkhangaiTotal));
        addRow(1, new Label("Баян-Өлгий:"), new HBox(bayanUlgiiProgressBar, bayanUlgiiProgress),  new HBox(bayanUlgiiVotes,bayanUlgiiTotal));
        addRow(2, new Label("Баянхонгор:"), new HBox(bayanhongorProgressBar, bayanhongorProgress),  new HBox(bayanhongorVotes,bayanhongorTotal));
        addRow(3, new Label("Булган:"), new HBox(bulganProgressBar, bulganProgress),  new HBox(bulganVotes,bulganTotal));
        addRow(4, new Label("Говь-Алтай:"), new HBox(goviAltaiProgressBar, goviAltaiProgress),  new HBox(goviAltaiVotes,goviAltaiTotal));
        addRow(5, new Label("Говьсүмбэр:"), new HBox(govisumberProgressBar, govisumberProgress),  new HBox(govisumberVotes,govisumberTotal));
        addRow(6, new Label("Дархан-Уул:"), new HBox(darhanUulProgressBar, darhanUulProgress),  new HBox(darhanUulVotes,darhanUulTotal));
        addRow(7, new Label("Дорноговь:"), new HBox(dornogoviProgressBar, dornogoviProgress),  new HBox(dornogoviVotes,dornogoviTotal));
        addRow(8, new Label("Дорнод:"), new HBox(dornodProgressBar, dornodProgress),  new HBox(dornodVotes,dornodTotal));
        addRow(9, new Label("Дундговь:"), new HBox(dundgoviProgressBar, dundgoviProgress),  new HBox(dundgoviVotes,dundgoviTotal));
        addRow(10, new Label("Завхан:"), new HBox(zavhanProgressBar, zavhanProgress),  new HBox(zavhanVotes,zavhanTotal));
    }



    public void bindToWorker(final Worker<ObservableList<Integer>> worker){
        arkhangaiVotes.textProperty().bind(
                new When(worker.workDoneProperty().isEqualTo(-1)).then("Unknown")
                        .otherwise(worker.workDoneProperty().asString()));

        arkhangaiProgress.textProperty().bind(
                new When(worker.progressProperty().isEqualTo(-1)).then("Unknown")
                        .otherwise(worker.progressProperty().multiply(100.0).asString("%.2f%%")));

        arkhangaiProgressBar.progressProperty().bind(worker.progressProperty());


//        bayanUlgiiVotes.textProperty().bind(
//                new When(worker.workDoneProperty().isEqualTo(-1)).then("Unknown")
//                        .otherwise(worker.workDoneProperty().asString()));
//
//        bayanUlgiiProgress.textProperty().bind(
//                new When(worker.progressProperty().isEqualTo(-1)).then("Unknown")
//                        .otherwise(worker.progressProperty().multiply(100.0).asString("%.2f%%")));
//
//        bayanUlgiiProgressBar.progressProperty().bind(worker.progressProperty());



    }

}
