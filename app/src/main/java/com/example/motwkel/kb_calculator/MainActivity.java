package com.example.motwkel.kb_calculator;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;


public class MainActivity extends AppCompatActivity {

    public char op;
    Button number_0, number_1, number_2, number_3, number_4, number_5, number_6,
            number_7, number_8, number_9, addition, Subtract, multiplication,
            division, dot, buttonC, equal, percent, r_square,
            one_divide_by, x_square, absolute, plus_minus;
    EditText editText;
    TextView textView;
    ImageButton delete;
    boolean isAddition, isSubtraction, isMultiplication, isDivision, isPercent, isNumber = false;
    private double mValueOne, mValueTwo;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.about_app) {
            Intent a = new Intent(MainActivity.this, About_app.class);
            startActivity(a);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
        } else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch color_switch;
        color_switch = (Switch) findViewById(R.id.color_switch);


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            color_switch.setChecked(true);
        }
        color_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }

            }
        });

        number_0 = (Button) findViewById(R.id.number_0);
        number_1 = (Button) findViewById(R.id.number_1);
        number_2 = (Button) findViewById(R.id.number_2);
        number_3 = (Button) findViewById(R.id.number_3);
        number_4 = (Button) findViewById(R.id.number_4);
        number_5 = (Button) findViewById(R.id.number_5);
        number_6 = (Button) findViewById(R.id.number_6);
        number_7 = (Button) findViewById(R.id.number__7);
        number_8 = (Button) findViewById(R.id.number_8);
        number_9 = (Button) findViewById(R.id.number__9);
        dot = (Button) findViewById(R.id.dot);
        addition = (Button) findViewById(R.id.plus);
        Subtract = (Button) findViewById(R.id.minus);
        multiplication = (Button) findViewById(R.id.multi);
        division = (Button) findViewById(R.id.div);
        buttonC = (Button) findViewById(R.id.c);
        equal = (Button) findViewById(R.id.equal);
        percent = (Button) findViewById(R.id.percent);
        r_square = (Button) findViewById(R.id.r_square);
        one_divide_by = (Button) findViewById(R.id.one_divide_by);
        x_square = (Button) findViewById(R.id.x_square);
        plus_minus = (Button) findViewById(R.id.plus_minus);
        absolute = (Button) findViewById(R.id.motlak);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        delete = (ImageButton) findViewById(R.id.clear);

        editText.setRawInputType(InputType.TYPE_NULL);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        number_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("0");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("1");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("2");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("3");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("4");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("5");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("6");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("7");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("8");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });
        number_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                append("9");
                textView.setText(editText.getText());
                isNumber = true;
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    isAddition = true;
                    textView.setText(mValueOne + "+");
                    isNumber = false;
                    editText.setText(null);
                    op = '+';
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

        });

        Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    isSubtraction = true;
                    textView.setText(mValueOne + "-");
                    isNumber = false;
                    editText.setText(null);
                    op = '-';
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    isMultiplication = true;
                    textView.setText(mValueOne + "*");
                    isNumber = false;
                    editText.setText(null);
                    op = '*';
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    isDivision = true;
                    textView.setText(mValueOne + "/");
                    isNumber = false;
                    editText.setText(null);
                    op = '/';
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    isPercent = true;
                    textView.setText(mValueOne + "%");
                    isNumber = false;
                    editText.setText(null);
                    op = '%';
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueTwo = Double.parseDouble(editText.getText() + "");

                    if (isAddition == true) {
                        if (op == '+') {
                            editText.setText(mValueOne + mValueTwo + "");
                            textView.setText(mValueOne + "+" + mValueTwo+"=");
                            isAddition = false;
                        }
                    }

                    if (isSubtraction == true) {
                        if (op == '-') {
                            editText.setText(mValueOne - mValueTwo + "");
                            textView.setText(mValueOne + "-" + mValueTwo+"=");
                            isSubtraction = false;
                        }
                    }

                    if (isMultiplication == true) {
                        if (op == '*') {
                            editText.setText(mValueOne * mValueTwo + "");
                            textView.setText(mValueOne + "*" + mValueTwo+"=");
                            isMultiplication = false;
                        }
                    }

                    if (isDivision == true) {
                        if (op == '/') {
                            editText.setText(mValueOne / mValueTwo + "");
                            textView.setText(mValueOne + "/" + mValueTwo+"=");
                            isDivision = false;
                        }
                    }

                    if (isPercent == true) {
                        if (op == '%') {
                            editText.setText(mValueOne / 100 * mValueTwo + "");
                            textView.setText(mValueOne + "%" + mValueTwo+"=");
                            isPercent = false;

                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                editText.setText("");
                textView.setText("");
                if (isEmpty()) {
                    mValueOne = 0;
                    mValueTwo = 0;
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty()) {
                        editText.setText(editText.getText() + "0.");
                    } else if (!isNumber || isDot()) {
                        editText.setText(editText.getText());
                    } else
                        editText.setText(editText.getText() + ".");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        x_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter number to give the square !", Toast.LENGTH_SHORT).show();
                    } else {
                        mValueOne = Double.parseDouble(editText.getText() + "");
                        double x_square = mValueOne * mValueOne;
                        editText.setText(x_square + "");
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                textView.setText(mValueOne + "²=");

                isNumber = false;
            }
        });

        one_divide_by.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter number to divide it by one !", Toast.LENGTH_SHORT).show();
                    } else {
                        mValueOne = Double.parseDouble(editText.getText() + "");
                        double on_divide_by = 1 / mValueOne;
                        editText.setText(on_divide_by + "");
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                textView.setText("¹/" + mValueOne + "=");

                isNumber = false;
            }
        });

        absolute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter number to absolute !", Toast.LENGTH_SHORT).show();
                    } else {
                        mValueOne = Double.parseDouble(editText.getText() + "");
                        double m = abs(mValueOne);
                        editText.setText(m + "");
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                textView.setText("|" + mValueOne + "| =");
                isNumber = false;
            }
        });

        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(editText.getText() + "");
                    if (isEmpty()) {
                        editText.setText(1 * -1 + "0.");
                    } else
                        editText.setText(mValueOne * -1 + "");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                isNumber = false;
            }
        });


        r_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter number to give The root !", Toast.LENGTH_SHORT).show();
                    } else {
                        mValueOne = Double.parseDouble(editText.getText() + "");
                        if (mValueOne > 0) {
                            double n = sqrt(mValueOne);
                            editText.setText(n + "");
                        } else {
                            editText.setText("");
                            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                if (mValueOne > 0)
                    textView.setText("√" + mValueOne + "=");
                else
                    textView.setText("");

                isNumber = false;
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {
                    String msg = textView.getText().toString();
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Text copied", msg);
                    clipboard.setPrimaryClip(clipData);
                    Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void replace(String str) {
        this.editText.getText().replace(getEdit().length() - 1, getEdit().length(), str);
    }

    private void append(String st) {
        this.editText.getText().append(st);
    }

    private void clear() {
        editText.getText().clear();
    }

    private void delete() {
        if (!isEmpty())
            this.editText.getText().delete(getEdit().length() - 1, getEdit().length());
    }

    private String getEdit() {
        return this.editText.getText().toString();
    }

    private boolean isEmpty() {
        return getEdit().isEmpty();
    }

    private boolean isDot() {
        return getEdit().contains(".");
    }

    public void restartApp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

   /*
    private boolean endWithOp(){
        return getEdit().endsWith("+") || getEdit().endsWith("-")|| getEdit().endsWith("*") || getEdit().endsWith("/");
    }
    */


}