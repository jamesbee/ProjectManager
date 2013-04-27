package com.pm.Data;

public enum TYPE {
	DEFAULT,//默认值，不处理
	CAR_FLOOR,//查询车流量的id
	CAR_COUNT,//查询在校车辆数的id
	CAR_BREAK_RULE,//查询违章车辆
	CAR_OVERNIGHT_CURR,//查询当日过夜车辆
	CAR_OVERNIGHT_PERIAD,//查询某时间段内过夜车辆
	CAR_OVER_NIGHTS_COUNT,//查询某车辆历史过夜天数
	CAR_OTHEN_OVER_NIGHTS//查询经常过夜车辆
}
