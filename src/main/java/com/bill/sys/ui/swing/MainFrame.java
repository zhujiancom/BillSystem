package com.bill.sys.ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import org.zj.framework.core.config.PropertyConstants;
import org.zj.framework.tools.properties.PropertyUtils;

import com.bill.sys.ui.swing.listeners.CleanListener;
import com.bill.sys.ui.swing.listeners.QueryListener;
import com.bill.sys.ui.swing.listeners.SystemInitHandler;
import com.bill.sys.ui.swing.model.OrderTable;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8216786708977859424L;
	
	private JButton queryBtn;
	private JButton cleanBtn;
	private JTextField timeInput;
	private JScrollPane mainScrollPane;
	private JScrollPane subScrollPane;
	private JTable mainTable; //展示order 列表
	private JTable itemTable; //展示 orderItem 列表
	
	private JLabel posValue;
	private JLabel mtValue;
	private JLabel tgValue;
	private JLabel eleFreeValue;
	private JLabel eleValue;
	private JLabel tddValue;
	private JLabel mtwmValue;
	private JLabel mtwmFreeValue;
	private JLabel mtSuperValue;
	private JLabel mtSuperFreeValue;
	private JLabel freeValue;
	private JLabel totalValue;
	
	public MainFrame(){
		initComponent();
		QueryListener listener = new QueryListener(mainTable, itemTable);
		listener.setTimeInput(timeInput);
		listener.setEleValue(eleValue);
		listener.setMtValue(mtValue);
		listener.setPosValue(posValue);
		listener.setEleFreeValue(eleFreeValue);
		listener.setTddValue(tddValue);
		listener.setTgValue(tgValue);
		listener.setMtwmValue(mtwmValue);
		listener.setMtwmFreeValue(mtwmFreeValue);
		listener.setMtSuperValue(mtSuperValue);
		listener.setMtSuperFreeValue(mtSuperFreeValue);
		listener.setFreeValue(freeValue);
		listener.setTotalValue(totalValue);
		queryBtn.registerKeyboardAction(listener, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		queryBtn.addActionListener(listener);
		
		CleanListener clistener = new CleanListener(mainTable, itemTable);
		clistener.setTimeInput(timeInput);
		clistener.setEleValue(eleValue);
		clistener.setMtValue(mtValue);
		clistener.setPosValue(posValue);
		clistener.setEleFreeValue(eleFreeValue);
		clistener.setTddValue(tddValue);
		clistener.setTgValue(tgValue);
		clistener.setMtwmValue(mtwmValue);
		clistener.setMtwmFreeValue(mtwmFreeValue);
		clistener.setMtSuperValue(mtSuperValue);
		clistener.setMtSuperFreeValue(mtSuperFreeValue);
		clistener.setFreeValue(freeValue);
		clistener.setTotalValue(totalValue);
		cleanBtn.addActionListener(clistener);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	private void initComponent() {
		this.setTitle((String) PropertyUtils.getProperties(PropertyConstants.SYSNAME));
		Container containerPanel = this.getContentPane();
		BorderLayout layout = new BorderLayout(0, 10);
		containerPanel.setLayout(layout);
		
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu sysMenu = new JMenu("系统");
		JMenu helpMenu = new JMenu("帮助");
		menubar.add(sysMenu);
		menubar.add(helpMenu);
		JMenuItem dataInit = new JMenuItem("数据初始化");
		JMenuItem settings = new JMenuItem("参数设置");
		JMenuItem helpInfo = new JMenuItem("帮助信息");
		sysMenu.add(dataInit);
		sysMenu.add(settings);
		helpMenu.add(helpInfo);
		SystemInitHandler handler = new SystemInitHandler();
		dataInit.addActionListener(handler.dataInit());
		settings.addActionListener(handler.settings());
		helpMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "帮助信息。。。。。");
			}
		});
		
		JPanel formPanel = new JPanel();
		JLabel rciTime = new JLabel("日期");
		timeInput = new JTextField(10);
		queryBtn = new JButton("查询");
		cleanBtn = new JButton("清空");
		formPanel.add(rciTime);
		formPanel.add(timeInput);
		formPanel.add(queryBtn);
		formPanel.add(cleanBtn);
		formPanel.setVisible(true);
		formPanel.setSize(500, 300);
		formPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		containerPanel.add(formPanel, BorderLayout.NORTH);
		
//		JPanel dataPanel = new JPanel();
		JSplitPane dataPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		containerPanel.add(dataPanel, BorderLayout.CENTER);
		dataPanel.setDividerLocation(800);
		dataPanel.setDividerSize(5);
		mainScrollPane = new JScrollPane(); //将表格加入到滚动条组件中
//		mainScrollPane.setMaximumSize(new Dimension(400,600));
		mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainTable = new OrderTable();
		mainScrollPane.setViewportView(mainTable);
		subScrollPane = new JScrollPane(); //将表格加入到滚动条组件中
//		subScrollPane.setMaximumSize(new Dimension(300,600));
//		subScrollPane.setMinimumSize(new Dimension(300,600));
		subScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		itemTable = new JTable();
		subScrollPane.setViewportView(itemTable);
		dataPanel.add(mainScrollPane);
		dataPanel.add(subScrollPane);
		
		JPanel conclusionPanel = new JPanel();
		containerPanel.add(conclusionPanel, BorderLayout.SOUTH);
		conclusionPanel.setLayout(new GridLayout(13, 1));
		
		JLabel pos = new JLabel("收银机入账总额：");
		posValue = new JLabel();
		posValue.setForeground(Color.RED);
		JPanel posPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		posPanel.add(pos);
		posPanel.add(posValue);
		
		JLabel mt = new JLabel("美团入账总额：");
		mtValue = new JLabel();
		mtValue.setForeground(Color.RED);
		JPanel mtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mtPanel.add(mt);
		mtPanel.add(mtValue);
		
		JLabel tg = new JLabel("大众点评团购入账总额：");
		tgValue = new JLabel();
		tgValue.setForeground(Color.RED);
		JPanel tgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tgPanel.add(tg);
		tgPanel.add(tgValue);
		
		JLabel eleFreeLabel = new JLabel("饿了么补贴总额：");
		eleFreeValue = new JLabel();
		eleFreeValue.setForeground(Color.RED);
		JPanel eleFreePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		eleFreePanel.add(eleFreeLabel);
		eleFreePanel.add(eleFreeValue);
		
		JLabel ele = new JLabel("饿了么入账总额：");
		eleValue = new JLabel();
		eleValue.setForeground(Color.RED);
		JPanel elePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		elePanel.add(ele);
		elePanel.add(eleValue);
		
		JLabel tdd = new JLabel("淘点点入账总额：");
		tddValue = new JLabel();
		tddValue.setForeground(Color.RED);
		JPanel tddPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tddPanel.add(tdd);
		tddPanel.add(tddValue);
		
		JLabel mtwm = new JLabel("美团外卖入账总额：");
		mtwmValue = new JLabel();
		mtwmValue.setForeground(Color.RED);
		JPanel mtwmPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mtwmPanel.add(mtwm);
		mtwmPanel.add(mtwmValue);
		
		JLabel mtwmFreeLabel = new JLabel("美团外卖补贴总额：");
		mtwmFreeValue = new JLabel();
		mtwmFreeValue.setForeground(Color.RED);
		JPanel mtwmFreePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mtwmFreePanel.add(mtwmFreeLabel);
		mtwmFreePanel.add(mtwmFreeValue);
		
		JLabel mtSuperLabel = new JLabel("美团超级代金券支付金额：");
		mtSuperValue = new JLabel();
		mtSuperValue.setForeground(Color.RED);
		JPanel mtSuperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mtSuperPanel.add(mtSuperLabel);
		mtSuperPanel.add(mtSuperValue);
		
		JLabel mtSuperFreeLabel = new JLabel("美团超级代金券补贴金额：");
		mtSuperFreeValue = new JLabel();
		mtSuperFreeValue.setForeground(Color.RED);
		JPanel mtSuperFreePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mtSuperFreePanel.add(mtSuperFreeLabel);
		mtSuperFreePanel.add(mtSuperFreeValue);
		
		JLabel freeLabel = new JLabel("总免单金额：");
		freeValue = new JLabel();
		freeValue.setForeground(Color.RED);
		JPanel freePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		freePanel.add(freeLabel);
		freePanel.add(freeValue);
		
		JLabel totalLabel = new JLabel("当日营业收入总额：");
		totalValue = new JLabel();
		totalValue.setForeground(Color.RED);
		JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		totalPanel.add(totalLabel);
		totalPanel.add(totalValue);
		
		conclusionPanel.add(posPanel);
		conclusionPanel.add(tgPanel);
		conclusionPanel.add(mtPanel);
		conclusionPanel.add(elePanel);
		conclusionPanel.add(eleFreePanel);
		conclusionPanel.add(mtwmPanel);
		conclusionPanel.add(mtwmFreePanel);
		conclusionPanel.add(mtSuperPanel);
		conclusionPanel.add(mtSuperFreePanel);
		conclusionPanel.add(tddPanel);
		conclusionPanel.add(freePanel);
		conclusionPanel.add(totalPanel);
	}
}
