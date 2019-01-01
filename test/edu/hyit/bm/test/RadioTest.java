package edu.hyit.bm.test;

import java.awt.Font;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class RadioTest {

	private static JFrame jframe;

	public static void main(String[] agrs)	
    {
		jframe = new JFrame();
		SpinnerDateModel model = new SpinnerDateModel();
        //获得JSPinner对象
        JSpinner year = new JSpinner(model);
        year.setValue(new Date());
        //设置时间格式
        JSpinner.DateEditor editor = new JSpinner.DateEditor(year,
                "yyyy-MM-dd HH:mm:ss");
        year.setEditor(editor);
        year.setBounds(34, 67, 219, 22);
        jframe.getContentPane().add(year);
        jframe.setBounds(300, 300, 300, 300);
        jframe.setVisible(true);
    }
}
