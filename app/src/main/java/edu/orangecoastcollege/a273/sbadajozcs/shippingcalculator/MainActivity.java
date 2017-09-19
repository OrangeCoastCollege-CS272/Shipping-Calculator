package edu.orangecoastcollege.a273.sbadajozcs.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private EditText mWeightEditText;
    private TextView mBaseCostTextView;
    private TextView mAddedCostTextView;
    private TextView mTotalCostTextView;

    private ShipItem mShipItem;

    NumberFormat mCurrency = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeightEditText = (EditText) findViewById(R.id.weightEditText);
        mBaseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        mAddedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        mTotalCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        mWeightEditText.addTextChangedListener(textChangedListener);

        mShipItem = new ShipItem();
    }

    private final TextWatcher textChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mShipItem.setOunces(Integer.parseInt(charSequence.toString()));
            } catch (NumberFormatException e) {
                mShipItem.setOunces(0);
            }
            update();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void update() {
        mBaseCostTextView.setText(mCurrency.format(mShipItem.getBASE_COST()));
        mAddedCostTextView.setText(mCurrency.format(mShipItem.calculateAddedCost()));
        mTotalCostTextView.setText(mCurrency.format(mShipItem.calculateTotalCost()));
    }
}
