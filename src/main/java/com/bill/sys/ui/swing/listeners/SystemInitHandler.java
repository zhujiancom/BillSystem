package com.bill.sys.ui.swing.listeners;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * 
 * @author zj
 *	
 * 项目名称：ReconciliationPro
 *
 * 类名称：SystemInitHandler
 *
 * 包名称：com.rci.ui.swing.handler
 *
 * Create Time: 2015年4月24日 下午2:56:16
 *
 * remark (备注): 系统初始化
 *
 */
public class SystemInitHandler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4393899033664657099L;
//	private SystemInitService service;
//	
//	public SystemInitHandler(){
//		service = (InitSystemService) SpringUtils.getBean("InitSystemService");
//	}
//
//	
	public ActionListener dataInit(){
//		return new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				service.init();
//				JOptionPane.showMessageDialog(null, "数据初始化成功！");
//			}
//		};
		return null;
	}
//	
	public ActionListener settings(){
//		return new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JFrame frame = new JFrame("参数设置");
//				Container contentPane  = frame.getContentPane();
//				GridBagLayout gridbag = new GridBagLayout();
//				contentPane.setLayout(gridbag);
//				GridBagConstraints c = new GridBagConstraints();
//				c.fill = GridBagConstraints.WEST;
//				c.anchor = GridBagConstraints.NORTHWEST;
//				JLabel l1 = new JLabel("大众点评方案");
//				add(gridbag,l1,c,0,0,1,1);
//				contentPane.add(l1);
//				JButton b1 = new JButton("添加");
//				add(gridbag,b1,c,1,0,5,1);
//				contentPane.add(b1);
//				
//				JPanel p1 = createDZDPPanel();
//				c.ipadx = 10;
//				add(gridbag,p1,c,0,1,1,99);
//				contentPane.add(p1);
//				
//				frame.setSize(600, 480);
//				frame.addWindowListener(new WindowAdapter() {
//					@Override
//					public void windowClosed(WindowEvent e) {
//						super.windowClosed(e);
//					}
//				});
//				frame.setLocationRelativeTo(null); // 相对居中, 在frame设置size之后
//				frame.setVisible(true);
//			}
//
//			private JPanel createDZDPPanel() {
//				JPanel p = new JPanel();
//				p.setBorder(BorderFactory.createLineBorder(Color.GRAY));
////				p.setPreferredSize(new Dimension(300, 200));
//				GridLayout layout = new GridLayout(0, 6);
//				p.setLayout(layout);
//				
//				JLabel l1 = new JLabel("方案名称");
//				JLabel l2 = new JLabel("抵用价格");
//				JLabel l3 = new JLabel("实际价格");
//				JLabel l4 = new JLabel("对冲金额");
//				JLabel l5 = new JLabel("返点率");
//				JLabel l6 = new JLabel("类型");
//				p.add(l1);
//				p.add(l2);
//				p.add(l3);
//				p.add(l4);
//				p.add(l5);
//				p.add(l6);
//				return p;
//			}
//			
//			private void add(GridBagLayout layout,Component comp,GridBagConstraints constraints,int x,int y,double wx,double wy){
//				add(layout,comp,constraints,x,y,wx,wy,30,20);
//			}
//			
//			private void add(GridBagLayout layout,Component comp,GridBagConstraints constraints,int x,int y,double wx,double wy,int width,int height){
////				constraints.gridwidth = width;
////				constraints.gridheight = height;
//				constraints.gridx = x;
//				constraints.gridy = y;
//				constraints.weightx = wx;
//				constraints.weighty = wy;
//				layout.setConstraints(comp, constraints);
//			}
//		};
		return null;
	}
}
