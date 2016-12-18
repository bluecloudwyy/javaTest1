import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Vector;

/**
 * Created by WYY on 2016/12/4.
 */
public class TestFrame extends JFrame {
    private Container c;
    private JRadioButton man;
    private JRadioButton woman;
    private ButtonGroup bg;
    private JCheckBox c1;
    private JCheckBox c2;
    private JCheckBox c3;
    private JComboBox comboBox;
    private DefaultComboBoxModel comboBoxModel;
    private DefaultListModel listModel;
    private JButton click;
    private JList list;
    public TestFrame(){
        setBounds(100,100,400,500);
        setLayout(new FlowLayout());
        c=getContentPane();
        man=new JRadioButton("男");
        woman=new JRadioButton("女");
        bg=new ButtonGroup();
        c1=new JCheckBox("篮球");
        c2=new JCheckBox("足球");
        c3=new JCheckBox("乒乓球");
        comboBoxModel=new DefaultComboBoxModel();
        comboBox=new JComboBox(comboBoxModel);
        click=new JButton("点击增加选项");
        click.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                comboBoxModel.addElement(random.nextInt(100));
            }

        });
        listModel=new DefaultListModel();
        listModel.addElement("1");
        listModel.addElement("2");
        listModel.addElement("3");
        JList list=new JList(new MyListModel());
        JPanel jPanel=new JPanel();
      //  jPanel.setLayout(null);
        JScrollPane jScrollPane=new JScrollPane(list);
       // jScrollPane.setBounds(0,0,50,50);
        jScrollPane.setPreferredSize(new Dimension(180,180));
        jScrollPane.setViewportView(list);
        bg.add(man);
        bg.add(woman);
        c.add(man);
        c.add(woman);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(comboBox);
        c.add(click);
     //   jPanel.setSize(200,200);
      //  jPanel.setPreferredSize(new Dimension(200,200));
        jScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(
               JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPanel.add(jScrollPane); //在面板中添加滚动面板，面板需要设置PreferredSize()
        c.add(jPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String []args){
        new TestFrame().setVisible(true);
    }
    class MyListModel extends AbstractListModel{
        private String[] args={"1","2","3"};
        @Override
        public int getSize() {
            return args.length;
        }

        @Override
        public Object getElementAt(int index) {
            return args[index];
        }
    }
}
