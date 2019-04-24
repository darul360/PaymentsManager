package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.ZoneId;

import javafx.scene.control.cell.PropertyValueFactory;
import logic.*;
import  java.util.Date;
import java.time.LocalDate;

public class Controller {
    private FuturePaymentRepository futurePaymentRepository = new FuturePaymentRepository();
    private PastPaymentRepository pastPaymentRepository = new PastPaymentRepository();
    ObservableList<String> typeOptions = FXCollections.observableArrayList("Gaz","Prąd","Czynsz");
    private DrawingClass drawingClass = new DrawingClass(pastPaymentRepository.getRepo(),futurePaymentRepository.getRepo());
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
    @FXML private CheckBox numberCheckBox;
    @FXML private CheckBox percentCheckBox2;
    @FXML private CheckBox numberCheckBox2;
    @FXML private  DatePicker from;
    @FXML private DatePicker to;
    @FXML private ToggleButton toggleChartsMode;
    @FXML private  Label Od,Do;

    @FXML private PieChart pieChart;

    @FXML
    void deslectCheckBoxes(){
        if(!chartsTab.isSelected()) {
            percentCheckBox.setSelected(false);
            percentCheckBox.setDisable(false);
            numberCheckBox.setSelected(false);
            numberCheckBox.setDisable(false);
            numberCheckBox2.setSelected(false);
            percentCheckBox2.setSelected(false);
            from.setDisable(true);to.setDisable(true);
            from.setValue(null);to.setValue(null);
            pieChartData.clear();

        }

    }

    @FXML
    void initializeFuturePaymentsChartWindow(){
        if(toggleChartsMode.isSelected()){
            toggleChartsMode.setStyle("-fx-background-color: #84ff96");

            percentCheckBox.setDisable(true);
            percentCheckBox.setSelected(false);
            percentCheckBox2.setDisable(false);

            numberCheckBox.setDisable(true);
            numberCheckBox.setSelected(false);
            numberCheckBox2.setDisable(false);

            from.setDisable(true);
            to.setDisable(true);
            from.setOpacity(0);
            to.setOpacity(0);
            Od.setOpacity(0);
            Do.setOpacity(0);

            if(pieChartData != null){
                pieChartData.clear();
            }
        }
        else{

            toggleChartsMode.setStyle("");

            percentCheckBox2.setSelected(false);
            percentCheckBox2.setDisable(true);
            percentCheckBox.setDisable(false);

            numberCheckBox2.setSelected(false);
            numberCheckBox2.setDisable(true);
            numberCheckBox.setDisable(false);

            from.setDisable(false);
            to.setDisable(false);
            from.setOpacity(1);
            to.setOpacity(1);
            Od.setOpacity(1);
            Do.setOpacity(1);

            if(pieChartData != null)
            pieChartData.clear();
        }
    }

    @FXML void drawFuturePaymentsChart(){
        Short one = 1,two=2,three=3;
        if(percentCheckBox2.isSelected()){
            numberCheckBox2.setSelected(false);
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.DOWN);
                float sum = drawingClass.ReturnTypeFuturePayments(one)+drawingClass.ReturnTypeFuturePayments(two)+drawingClass.ReturnTypeFuturePayments(three);
                float percentOne = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypeFuturePayments(one)))/sum)*100;
                float percentTwo = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypeFuturePayments(two)))/sum)*100;
                float percentThree = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypeFuturePayments(three)))/sum)*100;
                pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Gaz " + df.format(percentOne) + "%",percentOne),
                        new PieChart.Data("Prąd " + df.format(percentTwo) + "%",percentTwo),
                        new PieChart.Data("Czynsz " + df.format(percentThree) + "%",percentThree));
                pieChart.setData(pieChartData);
        }
        else {
            if(pieChartData != null)
                pieChartData.clear();
        }
    }

    @FXML void drawFuturePaymentsChart2(){
        Short one = 1,two=2,three=3;
        if(numberCheckBox2.isSelected()){

            percentCheckBox2.setSelected(false);
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.DOWN);

                pieChartData = FXCollections.observableArrayList();
                pieChartData.add(new PieChart.Data("Gaz " + df.format(drawingClass.returnSumOfFuturePayments(one)) +"zł",drawingClass.returnSumOfFuturePayments(one)));
                pieChartData.add(new PieChart.Data("Prąd " + df.format(drawingClass.returnSumOfFuturePayments(two)) +"zł",drawingClass.returnSumOfFuturePayments(two)));
                pieChartData.add(new PieChart.Data("Czynsz " + df.format(drawingClass.returnSumOfFuturePayments(three)) +"zł",drawingClass.returnSumOfFuturePayments(three)));
                pieChart.setData(pieChartData);
        }
        else {
            if(pieChartData != null)
                pieChartData.clear();
        }
    }


    @FXML //AMMOUNT
    void drawPastPaymentsChart(){
        Short one = 1,two=2,three=3;
        if(numberCheckBox.isSelected()){
            from.setDisable(false);to.setDisable(false);
            percentCheckBox.setSelected(false);
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.DOWN);

            if((from.getEditor().getText().length() == 0 && to.getEditor().getText().length() == 0) || (from.getEditor().getText().length() != 0 && to.getEditor().getText().length() == 0)
                    || (from.getEditor().getText().length() == 0 && to.getEditor().getText().length() != 0)){
            pieChartData = FXCollections.observableArrayList();
            pieChartData.add(new PieChart.Data("Gaz " + df.format(drawingClass.returnSumOfPayments(one)) +"zł",drawingClass.returnSumOfPayments(one)));
            pieChartData.add(new PieChart.Data("Prąd " + df.format(drawingClass.returnSumOfPayments(two)) +"zł",drawingClass.returnSumOfPayments(two)));
            pieChartData.add(new PieChart.Data("Czynsz " + df.format(drawingClass.returnSumOfPayments(three)) +"zł",drawingClass.returnSumOfPayments(three)));
            pieChart.setData(pieChartData);}

            if(from.getEditor().getText().length() != 0 && to.getEditor().getText().length() != 0){
                LocalDate date = from.getValue();
                int fromMonth = date.getMonthValue(); int fromDay = date.getDayOfMonth();
                LocalDate date2 = to.getValue();
                int toMonth = date2.getMonthValue(); int toDay = date2.getDayOfMonth();

                float sumOne = drawingClass.returnSumOfPaymentsBetweenDates(one,fromMonth,toMonth,fromDay,toDay);
                float sumTwo = drawingClass.returnSumOfPaymentsBetweenDates(two,fromMonth,toMonth,fromDay,toDay);
                float sumThree = drawingClass.returnSumOfPaymentsBetweenDates(three,fromMonth,toMonth,fromDay,toDay);

                pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Gaz " + df.format(sumOne) + "zł",sumOne),
                        new PieChart.Data("Prąd " + df.format(sumTwo) + "zł",sumTwo),
                        new PieChart.Data("Czynsz " + df.format(sumThree) + "zł",sumThree));
                pieChart.setData(pieChartData);

            }

            }
        else {
            pieChartData.clear();
            from.setDisable(true);to.setDisable(true);
            from.setValue(null);to.setValue(null);
        }

   }
   @FXML void Update(){
        if(numberCheckBox.isSelected())
        drawPastPaymentsChart();
        else
        drawPastPaymentsChart2();
    }

   @FXML //PERCENT
   void drawPastPaymentsChart2(){
       Short one = 1,two=2,three=3;
       if(percentCheckBox.isSelected()){
            from.setDisable(false);to.setDisable(false);
            numberCheckBox.setSelected(false);
           DecimalFormat df = new DecimalFormat("##.##");
           df.setRoundingMode(RoundingMode.DOWN);

           if((from.getEditor().getText().length() == 0 && to.getEditor().getText().length() == 0) || (from.getEditor().getText().length() != 0 && to.getEditor().getText().length() == 0)
           || (from.getEditor().getText().length() == 0 && to.getEditor().getText().length() != 0)){

               float sum = drawingClass.ReturnTypePastPayments(one)+drawingClass.ReturnTypePastPayments(two)+drawingClass.ReturnTypePastPayments(three);
               float percentOne = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(one)))/sum)*100;
               float percentTwo = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(two)))/sum)*100;
               float percentThree = (Float.parseFloat(Integer.toString(drawingClass.ReturnTypePastPayments(three)))/sum)*100;

           pieChartData = FXCollections.observableArrayList(
                   new PieChart.Data("Gaz " + df.format(percentOne) + "%",percentOne),
                   new PieChart.Data("Prąd " + df.format(percentTwo) + "%",percentTwo),
                   new PieChart.Data("Czynsz " + df.format(percentThree) + "%",percentThree));
           pieChart.setData(pieChartData);
           }


           if(from.getEditor().getText().length() != 0 && to.getEditor().getText().length() != 0){
               LocalDate date = from.getValue();
               int fromMonth = date.getMonthValue(); int fromDay = date.getDayOfMonth();
               LocalDate date2 = to.getValue();
               int toMonth = date2.getMonthValue(); int toDay = date2.getDayOfMonth();

               float ones = drawingClass.countPaymentsBetweenDates(one,fromMonth,toMonth,fromDay,toDay);
               float twos = drawingClass.countPaymentsBetweenDates(two,fromMonth,toMonth,fromDay,toDay);
               float threes = drawingClass.countPaymentsBetweenDates(three,fromMonth,toMonth,fromDay,toDay);
               float sumOTT = ones+twos+threes;
               ones=(ones/sumOTT)*100;
               twos=(twos/sumOTT)*100;
               threes=(threes/sumOTT)*100;

               pieChartData = FXCollections.observableArrayList(
                       new PieChart.Data("Gaz " + df.format(ones) + "%",ones),
                       new PieChart.Data("Prąd " + df.format(twos) + "%",twos),
                       new PieChart.Data("Czynsz " + df.format(threes) + "%",threes));
               pieChart.setData(pieChartData);

           }
       }
       else {
           pieChartData.clear();
           from.setDisable(true);to.setDisable(true);
           from.setValue(null);to.setValue(null);
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
        ID++;
        chartsTab.setDisable(false);
        }
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
            chartsTab.setDisable(false);
        }
    }

     public Controller() { }
}
