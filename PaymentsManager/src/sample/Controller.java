package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import  javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.*;
import  java.util.Date;
import java.time.LocalDate;

public class Controller {
    private FuturePaymentRepository futurePaymentRepository = new FuturePaymentRepository();
    private PastPaymentRepository pastPaymentRepository = new PastPaymentRepository();
    ObservableList<String> typeOptions = FXCollections.observableArrayList("Gaz","Prąd","Czynsz");
    private DrawingClass drawingClass = new DrawingClass(pastPaymentRepository.getRepo());
    private int ID =0,pastID=0;
    private  ObservableList<PieChart.Data> pieChartData;



    @FXML private TableView <FuturePayment> mainPaymentsTable;
    @FXML private TableColumn <FuturePayment,Integer> idCol;
    @FXML private  TableColumn <FuturePayment,String> nameCol;
    @FXML private  TableColumn <FuturePayment,Float> priceCol;
    @FXML private  TableColumn <FuturePayment,Short> typeCol;
    @FXML private  TableColumn <FuturePayment,String> descCol;

    @FXML private TableView <PastPayment> pastPaymentsTable;
    @FXML private TableColumn <PastPayment,Integer> idColumn;
    @FXML private  TableColumn <PastPayment,String> nameColumn;
    @FXML private  TableColumn <PastPayment,Float> priceColumn;
    @FXML private  TableColumn <PastPayment,Short> typeColumn;
    @FXML private  TableColumn <PastPayment,String> descColumn;
    @FXML private  TableColumn <PastPayment,Date> dateColumn;

    @FXML private TextField nameTextField;
    @FXML private TextField priceTextField;
    @FXML private ChoiceBox choiceBox;
    @FXML private  TextField descTextField;
    @FXML private TextField finalDescTextField;
    @FXML private Tab mainTab;
    @FXML private Tab tableTab;
    @FXML private Tab chartsTab;
    @FXML private DatePicker datePicker;
    @FXML private  CheckBox percentCheckBox;
    @FXML private CheckBox numbertCheckBox;

    @FXML private PieChart pieChart;

    @FXML
    void deslectCheckBoxes(){
        if(!chartsTab.isSelected()) {
            percentCheckBox.setSelected(false);
            numbertCheckBox.setSelected(false);
            pieChartData.clear();
        }

    }

    @FXML //AMMOUNT
    void drawPastPaymentsChart(){
        Short one = 1,two=2,three=3;
        if(numbertCheckBox.isSelected()){
            percentCheckBox.setDisable(true);
            percentCheckBox.setSelected(false);
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.DOWN);

            pieChartData = FXCollections.observableArrayList();
            pieChartData.add(new PieChart.Data("Gaz " + df.format(drawingClass.returnSumOfPayments(one)) +"zł",drawingClass.returnSumOfPayments(one)));
            pieChartData.add(new PieChart.Data("Prąd " + df.format(drawingClass.returnSumOfPayments(two)) +"zł",drawingClass.returnSumOfPayments(two)));
            pieChartData.add(new PieChart.Data("Czynsz " + df.format(drawingClass.returnSumOfPayments(three)) +"zł",drawingClass.returnSumOfPayments(three)));
            pieChart.setData(pieChartData);}
        else {
            percentCheckBox.setDisable(false);
            pieChartData.clear();
        }

   }
   @FXML //PERCENT 🤣❤😍😎💋🚊
   void drawPastPaymentsChart2(){
       Short one = 1,two=2,three=3;
       if(percentCheckBox.isSelected()){
            numbertCheckBox.setDisable(true);
            numbertCheckBox.setSelected(false);
           DecimalFormat df = new DecimalFormat("##.##");
           df.setRoundingMode(RoundingMode.DOWN);

           float sum = drawingClass.ReturnTypePastPayments(one)+drawingClass.ReturnTypePastPayments(two)+drawingClass.ReturnTypePastPayments(three);
           float percentOne = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(one)))/sum)*100;
           float percentTwo = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(two)))/sum)*100;
           float percentThree = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(three)))/sum)*100;

           pieChartData = FXCollections.observableArrayList(
                   new PieChart.Data("Gaz " + df.format(percentOne) + "%",percentOne),
                   new PieChart.Data("Prąd " + df.format(percentTwo) + "%",percentTwo),
                   new PieChart.Data("Czynsz " + df.format(percentThree) + "%",percentThree));
           pieChart.setData(pieChartData);}
       else {
           numbertCheckBox.setDisable(false);
           pieChartData.clear();
       }

   }

    @FXML
    void openTabEvent() {
        if (tableTab.isSelected()) {
            ObservableList<PastPayment> pastPaymentList = FXCollections.observableArrayList(pastPaymentRepository.getRepo());
            pastPaymentsTable.setItems(pastPaymentList);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        }
    }

    @FXML
    void openMainTabEvent() {
        if (mainTab.isSelected()) {
            ObservableList<FuturePayment> futurePaymentsList = FXCollections.observableArrayList(futurePaymentRepository.getRepo());
            mainPaymentsTable.setItems(futurePaymentsList);
            idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
            descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        }
    }

    @FXML
    void initialize(){
        choiceBox.setItems((typeOptions));
    }

    @FXML
    void addFuturePaymentClick(ActionEvent actionEvent){
        short choiceBoxResult = 0;
        if(choiceBox.getValue().toString() == "Gaz") choiceBoxResult =1;
        if(choiceBox.getValue().toString() == "Prąd") choiceBoxResult =2;
        if(choiceBox.getValue().toString() == "Czynsz") choiceBoxResult =3;

        if(choiceBoxResult != 0 && nameTextField.getText() != null && priceTextField.getText() != null && descTextField.getText() != null){
        FuturePayment futurePayment = new FuturePayment(ID,nameTextField.getText(),Float.parseFloat(priceTextField.getText()),
                choiceBoxResult,descTextField.getText());
        futurePaymentRepository.AddToRepo(futurePayment);
        nameTextField.clear();priceTextField.clear();descTextField.clear();choiceBox.setValue(null);
        ID++;}
        openMainTabEvent();
    }

    @FXML
    void finishPaymentClick(ActionEvent actionEvent){
        if(mainPaymentsTable.getSelectionModel().getSelectedItem() != null && datePicker.getValue() != null){
        FuturePayment temp = mainPaymentsTable.getSelectionModel().getSelectedItem();
        Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        PastPayment pastPayment;
            if(finalDescTextField.getText() != null){
                pastPayment = new PastPayment(pastID,temp.getName(), temp.getPrice(),temp.getType(),finalDescTextField.getText(),date);
            }
            else{
                pastPayment = new PastPayment(pastID,temp.getName(), temp.getPrice(),temp.getType(),temp.getDescription(),date);
            }
            pastPaymentRepository.AddToRepo(pastPayment);
            futurePaymentRepository.DeletePayment(temp.getID());
            openMainTabEvent();
            finalDescTextField.clear();
            datePicker.getEditor().clear();
            pastID++;
        }
    }

     public Controller() { }
}
