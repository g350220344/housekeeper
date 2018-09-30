<template>
    <div class="cpc_page">
        <div class="cpc_chart_box">
            <div class="cpc_chart_unit">(元/㎡)</div>
            <div class="cpc_chart_tit vux-1px-b">均价走势对比</div>
            <div ref="chart" style="height: 4.7rem; margin: auto; padding-bottom: 0.62rem; padding-top: 0.2rem;"></div>
        </div>
    </div>
</template>

<script>
import 'assets/css/my/compare_chart.css'
export default {
    name: 'havings-report',
    data() {
        return {
            date: [1, 2, 3, 4, 5, 6], //均价走势时间轴
            series: [{ //均价走势数据
                label: '翠微北里',
                data: [6.3, 7.9, 7.3, 6.0, 7.5, 6.8]
            }, {
                label: '海淀区',
                data: [5.3, 4.9, 6.3, 3.0, 5.5, 5.8],
            }, {
                label: '北京市',
                data: [7.4, 9.4, 6.5, 8.6, 8.3, 7.5]
            }]
        }
    },
    methods: {
        init() {
            if(this.date.length == 0 || this.series.length == 0) {
                return;
            }
            let el = this.$refs.chart;
            var myRegression = echarts.init(el);
            var dateLableArr = this.date.map(d => {
                return d !== '' ?  d + "月" : '';
            });

            // var maxVal = Math.max.apply(Math, valArray);
            let series = this.series.map((item, index) => {
                return {
                    name: item.label,
                    data: item.data,
                    type: "line",
                    smooth: true,
                    symbolSize: "5"
                }
            })
            var option = {
                color:['#00d0c2', '#388cff', '#f9354d'],
                legend: {
                    data:['翠微北里','海淀区','北京市'],
                    icon: 'circle',
                    y: 'bottom',
                    itemWidth: 5,
                    padding: [20, 0, 0, 0]
                },
                grid: {
                    top: 30,
                    bottom: 35,
                    right: 10
                },
                tooltip: {
                    show: true
                },
                xAxis: {
                    type: "category",
                    data: dateLableArr,
                    offset: -13,
                    axisLabel: {
                        show: true,
                        color: "#bbb"
                    },
                    splitNumber: 2,
                    scale: true,
                    axisLine: {
                        show: false
                    },

                    axisTick: {
                        show: true,
                            lineStyle: {
                            color: "#fff"
                        }
                    },
                    splitLine: {
                        show: false,
                            lineStyle: {
                            type: "dotted",
                            color: "#fff"
                        }
                    },
                    boundaryGap: false
                },
                yAxis: {
                    type: "value",
                    scale: false,
                    offset: 10,
                    show: true,
                    axisLabel: {
                        show: true,
                        color: "#bbb"
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    splitLine: {
                        show: false
                    }
                },
                series: series
            };
            // 为echarts对象加载数据
            myRegression.setOption(option);
        }
    },
    mounted() {
        document.title = '持产报告'
        this.init();
    }
}
</script>
