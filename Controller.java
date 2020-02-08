package sample;
import javafx.css.Match;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.*;

import java.util.HashSet;
import java.util.Iterator;

public class Controller {

    @FXML
    public Label showResult;

    @FXML
    public TextField firstCoef;
    @FXML
    public TextField secondCoef;
    @FXML
    public TextField thirdCoef;
    @FXML
    public TextField equalcoef;


    public void sol(ActionEvent actionEvent) {
       HashSet<Double> solution = new HashSet<>();
        showResult.setText("");

        if(!checkData(firstCoef,secondCoef,thirdCoef,equalcoef))
        {
            showResult.setText("Вы ввели некооретные данные");
            return;
        }

        solution = solveEquals(firstCoef,secondCoef,thirdCoef,equalcoef);
        if(solution==null) {
            showResult.setText("Решений нет");
            return;
        }

        Iterator<Double> i= solution.iterator();
        while (i.hasNext()){
            showResult.setText(showResult.getText()+"\n Х="+i.next());
        }

        firstCoef.setText("");
        secondCoef.setText("");
        thirdCoef.setText("");
        equalcoef.setText("");


    }
    private boolean checkData(TextField f, TextField s, TextField t, TextField equalcoef){
        //
        String reg="^(0$|-?[1-9]\\d*(\\.\\d*[1-9]$)?|-?0\\.\\d*[1-9])$";
        return f.getText().matches(reg) && s.getText().matches(reg) &&
                t.getText().matches(reg) && equalcoef.getText().matches(reg);
    }

    private HashSet<Double> solveEquals(TextField f, TextField s, TextField t, TextField equalcoef){
        HashSet<Double> solves = new HashSet<>();
        double a = Double.parseDouble(f.getText());
        double b = Double.parseDouble(s.getText());
        double c= Double.parseDouble(t.getText());
        double e = Double.parseDouble(equalcoef.getText());
        c-=e; //
        double D =b*b-4*a*c;
        if(D<0) return null;

        double x = (-b+ Math.sqrt(D))/(2*a);
        solves.add(x);

        x=(-b- Math.sqrt(D))/(2*a);
        solves.add(x);

        return solves;

    }

}
