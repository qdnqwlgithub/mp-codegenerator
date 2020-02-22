package mp.codegenerator.main;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Main {
	public static void main(String[] args) {
		main01();
	}
	public static void main01() {
		// 1.全局配置
        GlobalConfig globalConfig=new GlobalConfig();
        globalConfig.setActiveRecord(true) // 是否支持AR模式
        .setAuthor("Midya") //作者
        .setOutputDir("D:\\workspace\\eclipseworkspace\\mp-codegenerator\\src\\main\\java") //生成路径
        .setFileOverride(true) // 文件覆盖
        //.setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I %sService的意思是不设置
        .setBaseResultMap(true) // 生成基本的resultMap映射表
        .setBaseColumnList(true).setEnableCache(false); // 生成基本的sql片段
        // 2.数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
        .setDriverName("com.mysql.jdbc.Driver")
        .setUrl("jdbc:mysql://122.51.138.168/ego")
        .setUsername("root")
        .setPassword("adsl23");
        // 3.策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setCapitalMode(true) // 全局大写命名
        .setDbColumnUnderline(true) // 表名是否用下划线驼峰命名
        .setNaming(NamingStrategy.underline_to_camel) // 数据库映射到实体的命名策略 NamingStrategy.underline_to_camel:下划线转驼峰命名
        .setTablePrefix("tb_") // 名表的前缀
        .setInclude("tb_administrators","tb_content","tb_content_category","tb_item","tb_item_cat","tb_item_desc","tb_item_param","tb_item_param_item","tb_order","tb_order_item","tb_order_shipping","tb_user"); // 多参数 里面是要生成的表名
        // 4.包名配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.ego") // 简化com.ego.* 此操作是给下面的包前面统一加父包(前缀)
        .setMapper("mapper").setXml("mapper").setEntity("pojo");
        // 5.整合配置:把上面的配置集成进来
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig).setStrategy(strategyConfig).setPackageInfo(packageConfig); // 生成代码
        autoGenerator.execute();
	}
}
