package com.bill.sys.ui.swing.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;

import org.springframework.util.CollectionUtils;
import org.zj.framework.core.exception.ExceptionConstant.SERVICE;
import org.zj.framework.core.exception.ExceptionManage;
import org.zj.framework.core.exception.ServiceException;
import org.zj.framework.tools.DateUtil;
import org.zj.framework.tools.SpringUtils;

import com.bill.sys.constants.BusinessConstant;
import com.bill.sys.service.IDataLoaderService;
import com.bill.sys.service.IOrderService;
import com.bill.sys.ui.swing.model.OrderItemTableModel;
import com.bill.sys.ui.swing.model.OrderTable;
import com.bill.sys.ui.swing.model.OrderTableModel;
import com.bill.sys.ui.swing.vos.OrderItemSwingVO;
import com.bill.sys.ui.swing.vos.OrderSwingVO;

public class QueryListener implements ActionListener,ListSelectionListener {
	private JTable mainTable;
	private JTable subTable;
	private IOrderService orderService;
	private IDataLoaderService loaderService;
	private JTextField timeInput;
	private List<OrderSwingVO> orders;
	private JLabel posValue;
	private JLabel mtValue;
	private JLabel tgValue;
	private JLabel eleFreeValue;
	private JLabel eleValue;
	private JLabel tddValue;
	private JLabel mtwmValue;
	private JLabel mtwmFreeValue;
	private JLabel freeValue;
	private JLabel mtSuperValue;
	private JLabel mtSuperFreeValue;
	private JLabel totalValue;
	
	public QueryListener(JTable mainTable,JTable subTable){
		this.mainTable = mainTable;
		this.subTable = subTable;
		orderService = (IOrderService) SpringUtils.getBean("OrderService");
		loaderService = (IDataLoaderService) SpringUtils.getBean("DataLoaderService");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String time = timeInput.getText();
		try{
			loadOrderData(time);
			posValue.setText(getTotalAmount(BusinessConstant.CASHMACHINE_ACC).toString());
			mtValue.setText(getTotalAmount(BusinessConstant.MT_ACC).toString());
			tgValue.setText(getTotalAmount(BusinessConstant.DPTG_ACC).toString());
			eleFreeValue.setText(getTotalAmount(BusinessConstant.FREE_ELE_ACC).toString());
			eleValue.setText(getTotalAmount(BusinessConstant.ELE_ACC).toString());
			tddValue.setText(getTotalAmount(BusinessConstant.TDD_ACC).toString());
			mtwmValue.setText(getTotalAmount(BusinessConstant.MTWM_ACC).toString());
			mtwmFreeValue.setText(getTotalAmount(BusinessConstant.FREE_MTWM_ACC).toString());
			mtSuperValue.setText(getTotalAmount(BusinessConstant.MT_SUPER_ACC).toString());
			mtSuperFreeValue.setText(getTotalAmount(BusinessConstant.FREE_MT_SUPER_ACC).toString());
			freeValue.setText(getTotalAmount(BusinessConstant.FREE_ACC).toString());
			totalValue.setText(getTotalDayAmount().toString());
			mainTable.getSelectionModel().addListSelectionListener(this);
		}catch(ServiceException se){
			JOptionPane.showMessageDialog(null, se.getMessage());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(event.getSource() == mainTable.getSelectionModel()
				&& mainTable.getRowSelectionAllowed()){
			int row = mainTable.getSelectedRow();
			if(row != -1){
				String payno = (String) mainTable.getValueAt(row, 1);
				loadItemData(payno);
			}
		}
	}
	
	/**
	 * 装载 order Item 数据
	 * @param payno
	 */
	public void loadItemData(String payno){
		List<OrderItemSwingVO> orderItems = orderService.queryOrderItemVOsByPayno(payno);
		OrderItemTableModel otm = new OrderItemTableModel(orderItems);
		subTable.setModel(otm);
		TableColumnModel cm = subTable.getColumnModel();
		cm.getColumn(0).setHeaderValue("菜品名称");
		cm.getColumn(0).setPreferredWidth(105);
		cm.getColumn(1).setHeaderValue("数量");
		cm.getColumn(1).setPreferredWidth(105);
		cm.getColumn(2).setHeaderValue("退菜数量");
		cm.getColumn(2).setPreferredWidth(75);
		cm.getColumn(3).setHeaderValue("原价");
		cm.getColumn(3).setPreferredWidth(75);
		cm.getColumn(4).setHeaderValue("实收金额");
		cm.getColumn(4).setPreferredWidth(75);
		cm.getColumn(5).setHeaderValue("折扣率");
		cm.getColumn(5).setPreferredWidth(115);
		cm.getColumn(6).setHeaderValue("消费时间");
		cm.getColumn(6).setPreferredWidth(140);
		subTable.setColumnModel(cm);
		subTable.setRowHeight(20);
		subTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	/**
	 * 装载 订单order 数据
	 * @param time
	 * @throws ServiceException
	 * @throws ParseException 
	 */
	public void loadOrderData(String time) throws ServiceException{
		if(!DateUtil.isDateFormat(time,"yyyyMMdd")){
			ExceptionManage.throwServiceException(SERVICE.TIME_FORMAT, "日期格式错误");
		}
		Date queryDate = null;
		try {
			queryDate = DateUtil.parseDate(time,"yyyyMMdd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar queryDay = Calendar.getInstance();
		queryDay.setTime(queryDate);
		Calendar currentDay = Calendar.getInstance();
		currentDay.setTime(DateUtil.getCurrentDate());
		if(queryDay.after(currentDay)){
			ExceptionManage.throwServiceException(SERVICE.TIME_FORMAT, "查询时间不能晚于当前时间");
		}
		
		loaderService.load(queryDate);
		List<OrderSwingVO> ordervos = orderService.accquireOrderVOsByDay(time);
		this.orders = ordervos;
		OrderTableModel otm = new OrderTableModel(orders);
		mainTable.setModel(otm);
		OrderTable ot = (OrderTable) mainTable; 
		ot.markRed();
		ot.setHeaderLabel();
		if(!CollectionUtils.isEmpty(ordervos)){
			OrderSwingVO order = otm.getOrderAt(0);
			loadItemData(order.getPayNo());
			mainTable.setRowSelectionAllowed(true);
			mainTable.setRowSelectionInterval(0, 0);
		}
		mainTable.setRowHeight(20);
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	public JTextField getTimeInput() {
		return timeInput;
	}

	public void setTimeInput(JTextField timeInput) {
		this.timeInput = timeInput;
	}
	
	public BigDecimal getTotalDayAmount(){
		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO,2);
		if(CollectionUtils.isEmpty(orders)){
			return totalAmount;
		}
		for(OrderSwingVO order:orders){
			totalAmount = totalAmount.add(order.getTotalAmount());
		}
		return totalAmount;
	}
	
	public BigDecimal getTotalAmount(String accountNo){
		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO,2);
		if(CollectionUtils.isEmpty(orders)){
			return totalAmount;
		}
		if(BusinessConstant.MT_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getMtAmount() != null){
					totalAmount = totalAmount.add(order.getMtAmount());
				}
			}
		}
		if(BusinessConstant.CASHMACHINE_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getCashmachineAmount() != null){
					totalAmount = totalAmount.add(order.getCashmachineAmount());
				}
			}
		}
		if(BusinessConstant.DPTG_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getDptgAmount() != null){
					totalAmount = totalAmount.add(order.getDptgAmount());
				}
			}
		}
		if(BusinessConstant.ELE_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getEleAmount() != null){
					totalAmount = totalAmount.add(order.getEleAmount());
				}
			}
		}
		if(BusinessConstant.TDD_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getTddAmount() != null){
					totalAmount = totalAmount.add(order.getTddAmount());
				}
			}
		}
		if(BusinessConstant.MTWM_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getMtwmAmount() != null){
					totalAmount = totalAmount.add(order.getMtwmAmount());
				}
			}
		}
		if(BusinessConstant.FREE_MTWM_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getMtwmFreeAmount() != null){
					totalAmount = totalAmount.add(order.getMtwmFreeAmount());
				}
			}
		}
		if(BusinessConstant.FREE_ELE_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getEleFreeAmount() != null){
					totalAmount = totalAmount.add(order.getEleFreeAmount());
				}
			}
		}
		if(BusinessConstant.FREE_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getFreeAmount() != null){
					totalAmount = totalAmount.add(order.getFreeAmount());
				}
			}
		}
		if(BusinessConstant.MT_SUPER_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getMtSuperAmount() != null){
					totalAmount = totalAmount.add(order.getMtSuperAmount());
				}
			}
		}
		if(BusinessConstant.FREE_MT_SUPER_ACC.equals(accountNo)){
			for(OrderSwingVO order:orders){
				if(order.getMtSuperFreeAmount() != null){
					totalAmount = totalAmount.add(order.getMtSuperFreeAmount());
				}
			}
		}
		
		return totalAmount;
	}

	public void setPosValue(JLabel posValue) {
		this.posValue = posValue;
	}

	public void setMtValue(JLabel mtValue) {
		this.mtValue = mtValue;
	}

	public void setTgValue(JLabel tgValue) {
		this.tgValue = tgValue;
	}

	public void setEleValue(JLabel eleValue) {
		this.eleValue = eleValue;
	}

	public void setTddValue(JLabel tddValue) {
		this.tddValue = tddValue;
	}

	public void setMtwmValue(JLabel mtwmValue) {
		this.mtwmValue = mtwmValue;
	}

	public void setEleFreeValue(JLabel eleFreeValue) {
		this.eleFreeValue = eleFreeValue;
	}

	public void setMtwmFreeValue(JLabel mtwmFreeValue) {
		this.mtwmFreeValue = mtwmFreeValue;
	}

	public void setFreeValue(JLabel freeValue) {
		this.freeValue = freeValue;
	}

	public void setTotalValue(JLabel totalValue) {
		this.totalValue = totalValue;
	}

	/**
	 * @param mtSuperValue the mtSuperValue to set
	 */
	public void setMtSuperValue(JLabel mtSuperValue) {
		this.mtSuperValue = mtSuperValue;
	}

	/**
	 * @param mtSuperFreeValue the mtSuperFreeValue to set
	 */
	public void setMtSuperFreeValue(JLabel mtSuperFreeValue) {
		this.mtSuperFreeValue = mtSuperFreeValue;
	}
}
