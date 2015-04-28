package com.bill.sys.ui.swing.model;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.zj.framework.tools.DateUtil;

import com.bill.sys.ui.swing.vos.OrderSwingVO;

public class OrderTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4006879882193678115L;
	private List<OrderSwingVO> orders = Collections.emptyList();
	
	public OrderTableModel(List<OrderSwingVO> orders){
		this.orders = orders;
	}
	
	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return 18;
	}
	
	public OrderSwingVO getOrderAt(int rowIndex){
		return orders.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderSwingVO order = orders.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ++rowIndex;
		case 1:
			return order.getPayNo();
		case 2:
			return order.getOriginAmount();
		case 3:
			return order.getActualAmount();
		case 4:
			return order.getNodiscountAmount();
		case 5:
			return order.getSchemeName();
		case 6:
			return order.getSingleDiscount();
		case 7:
			return DateUtil.time2Str(order.getCheckoutTime());
		case 8:
			return order.getCashmachineAmount();
		case 9:
			return order.getMtAmount();
		case 10:
			return order.getDptgAmount();
		case 11:
			return order.getEleAmount();
		case 12:
			return order.getEleFreeAmount();
		case 13:
			return order.getTddAmount();
		case 14:
			return order.getMtwmAmount();
		case 15:
			return order.getMtwmFreeAmount();
		case 16:
			return order.getFreeAmount();
		case 17:
			return order.getTotalAmount();
		default:
			break;
		}
		return null;
	}
	
	public void setRowCount(int rowCount){
		int old = getRowCount();
		orders = Collections.emptyList();
		if(old > 0){
			super.fireTableRowsDeleted(rowCount,old-1);
		}
	}

}
