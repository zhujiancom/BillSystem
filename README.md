# BillSystem
每日记账，对账系统

系统需求： 记账功能仿造网站“随手记” 功能开发
额外需求： 
          1.从sqlserver 数据库中获取每天营业单据等原始数据（下面简称“原数据”）。
          2.分析原数据，自动生成记账收入流水
          3.查看原数据每个票据的详细信息。
          4.根据每个单据不同的付费方式，自动将金额存入不同的账户。（如：使用大众点评代金券的用户，
                                                                        应该将代金券实际买入金额扣除返点金额后金额存入大众点评账户）
          5.实现流水导入导出功能，导入导出文件和随手记网站格式一样，方便和其交互。
          
          
具体事项：
	1.初始化系统基本信息，如账户信息
