package jLabelDemo;

import java.awt.Color ;
import java.awt.Dimension;
import java.awt.Point ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;
public class JLabelDemo{
    public static void main(String args[]){
        JFrame frame = new JFrame("JLable Test") ;
        JLabel lab = new JLabel("����һ����ǩ",JLabel.CENTER) ;   // ʵ������ǩ����
        frame.add(lab) ;    // ��������뵽���֮��
        frame.setBackground(Color.WHITE) ;//���ô���ı�����ɫ

        Dimension dim = new Dimension() ;
        dim.setSize(400,200) ;              //����Ĵ�С
        frame.setSize(dim) ;                //���ô����С
        Point point = new Point(500,100) ;  // ��������
        frame.setLocation(point) ;          //���ô�������
        frame.setVisible(true) ;            //���ô���ɼ�
    }
}