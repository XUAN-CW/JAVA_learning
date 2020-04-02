package jLabelDemo;

import java.awt.Color ;
import java.awt.Dimension;
import java.awt.Point ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;
public class JLabelDemo{
    public static void main(String args[]){
        JFrame frame = new JFrame("JLable Test") ;
        JLabel lab = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
        frame.add(lab) ;    // 将组件件入到面板之中
        frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色

        Dimension dim = new Dimension() ;
        dim.setSize(400,200) ;              //窗体的大小
        frame.setSize(dim) ;                //设置窗体大小
        Point point = new Point(500,100) ;  // 设置坐标
        frame.setLocation(point) ;          //设置窗体坐标
        frame.setVisible(true) ;            //设置窗体可见
    }
}