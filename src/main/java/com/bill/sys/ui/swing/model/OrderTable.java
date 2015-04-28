package com.bill.sys.ui.swing.model;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.zj.framework.core.enums.CommonEnums.YOrN;

import com.bill.sys.ui.swing.vos.OrderSwingVO;

public class OrderTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4935140318205918006L;
	
	public void markRed(){
		TableColumnModel tcm = this.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			TableColumn tc = tcm.getColumn(i);
			tc.setCellRenderer(new RowMarkReadRenderer());
		}
		TableColumn tc = tcm.getColumn(tcm.getColumnCount()-1);
		tc.setCellRenderer(new FeelOrderMarkRenderer());
	}
	
	public void setHeaderLabel(){
		TableColumnModel cm = this.getColumnModel();
		cm.getColumn(0).setHeaderValue("序号");
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setHeaderValue("付款编号");
		cm.getColumn(1).setPreferredWidth(105);
		cm.getColumn(2).setHeaderValue("原价");
		cm.getColumn(2).setPreferredWidth(75);
		cm.getColumn(3).setHeaderValue("实收金额");
		cm.getColumn(3).setPreferredWidth(75);
		cm.getColumn(4).setHeaderValue("不可打折金额");
		cm.getColumn(4).setPreferredWidth(75);
		cm.getColumn(5).setHeaderValue("折扣方案");
		cm.getColumn(5).setPreferredWidth(175);
		cm.getColumn(6).setHeaderValue("有临时折扣方案");
		cm.getColumn(6).setPreferredWidth(45);
		cm.getColumn(7).setHeaderValue("结账时间");
		cm.getColumn(7).setPreferredWidth(140);
		cm.getColumn(8).setHeaderValue("pos机入账");
		cm.getColumn(8).setPreferredWidth(70);
		cm.getColumn(9).setHeaderValue("美团入账");
		cm.getColumn(9).setPreferredWidth(70);
		cm.getColumn(10).setHeaderValue("大众点评团购");
		cm.getColumn(10).setPreferredWidth(105);
		cm.getColumn(11).setHeaderValue("饿了么");
		cm.getColumn(11).setPreferredWidth(75);
		cm.getColumn(12).setHeaderValue("饿了么补贴");
		cm.getColumn(12).setPreferredWidth(105);
		cm.getColumn(13).setHeaderValue("淘点点");
		cm.getColumn(13).setPreferredWidth(75);
		cm.getColumn(14).setHeaderValue("美团外卖");
		cm.getColumn(14).setPreferredWidth(75);
		cm.getColumn(15).setHeaderValue("美团外卖补贴");
		cm.getColumn(15).setPreferredWidth(105);
		cm.getColumn(16).setHeaderValue("免单");
		cm.getColumn(16).setPreferredWidth(75);
		cm.getColumn(17).setHeaderValue("总金额");
		cm.getColumn(17).setPreferredWidth(75);
	}
	
	private class RowMarkReadRenderer extends DefaultTableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 4436771966347867353L;

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			OrderTableModel tm = (OrderTableModel) table.getModel();
			OrderSwingVO order = tm.getOrderAt(row);
			if(YOrN.Y.equals(order.getUnusual())){
				setBackground(Color.RED);
				setForeground(Color.WHITE);
			}else{
				setBackground(Color.WHITE);
				setForeground(Color.BLACK);
			}
			if(YOrN.Y.equals(order.getUnusual()) && isSelected){
				table.setSelectionBackground(Color.RED);
				table.setSelectionForeground(Color.WHITE);
			}else{
				table.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));
				table.setSelectionForeground(UIManager.getColor("Table.selectionForeground"));
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
					row, column);
		}
		
	}
	
	private class FeelOrderMarkRenderer extends DefaultTableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 9016998600727653300L;

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			OrderTableModel tm = (OrderTableModel) table.getModel();
			OrderSwingVO order = tm.getOrderAt(row);
			if(order.getTotalAmount().compareTo(BigDecimal.ZERO) == 0){
				setBackground(Color.YELLOW);
			}else{
				setBackground(Color.WHITE);
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
					row, column);
		}
		
	}

}
