package rubens.example.projetointegrador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class calculatora extends Activity implements View.OnClickListener{
    private ImageView numero0,numero1,numero2,numero3,numero4,numero5,numero6,numero7,numero8,numero9,ponto,soma,sub,mult,div,igual,botaolimpar,apagar;
    private TextView txtExpressao,txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatora);

        IniciarComponentes();
        numero0.setOnClickListener(this);
        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        soma.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        igual.setOnClickListener(this);

        botaolimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.expressao);
                String string = expressao.getText().toString();


                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));

                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }

            }


        });

    }
    private void IniciarComponentes(){
        numero0 = findViewById(R.id.btzero);
        numero1 = findViewById(R.id.btum);
        numero2 = findViewById(R.id.btdois);
        numero3 = findViewById(R.id.bttres);
        numero4 = findViewById(R.id.btquatro);
        numero5 = findViewById(R.id.btcinco);
        numero6 = findViewById(R.id.btseis);
        numero7 = findViewById(R.id.btsete);
        numero8 = findViewById(R.id.btoito);
        numero9 = findViewById(R.id.btnove);
        apagar = findViewById(R.id.btback);
        soma = findViewById(R.id.btmais);
        sub = findViewById(R.id.btmenos);
        div = findViewById(R.id.btbarra);
        mult = findViewById(R.id.btvezes);
        igual = findViewById(R.id.btigual);
        botaolimpar = findViewById(R.id.btapagar);
        txtExpressao = findViewById(R.id.expressao);
        txtResultado = findViewById(R.id.resultado);


    }
    public void AcrescentarExpressao(String string,boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btzero:
                AcrescentarExpressao("0",true);
                break;

            case R.id.btum:
                AcrescentarExpressao("1",true);
                break;
            case R.id.btdois:
                AcrescentarExpressao("2",true);
                break;
            case R.id.bttres:
                AcrescentarExpressao("3",true);
                break;
            case R.id.btquatro:
                AcrescentarExpressao("4",true);
                break;
            case R.id.btcinco:
                AcrescentarExpressao("5",true);
                break;
            case R.id.btseis:
                AcrescentarExpressao("6",true);
                break;
            case R.id.btsete:
                AcrescentarExpressao("7",true);
                break;
            case R.id.btoito:
                AcrescentarExpressao("8",true);
                break;
            case R.id.btnove:
                AcrescentarExpressao("9",true);
                break;
            case R.id.btmais:
                AcrescentarExpressao("+",true);
                break;
            case R.id.btmenos:
                AcrescentarExpressao("-",true);
                break;
            case R.id.btvezes:
                AcrescentarExpressao("*",true);
                break;

            case R.id.btbarra:
                AcrescentarExpressao("/",true);
                break;

            case R.id.btigual:
                AcrescentarExpressao("=",true);
                break;




        }
    }
}