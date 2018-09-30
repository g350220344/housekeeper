<template>
    <div v-if="date.length > 0 && series.length > 0" class="m_chart">
        <div ref="iChartItem" class="m_chart_box"></div>
        <div v-if="unit" class="m_chart_unit">({{unit}})</div>
        <div class="m_chart_lends">
            <template v-for="(item, index) in series">
                <i class="dot" :style="{'margin-left': index != 0 ? '0.69rem': '0'}" :class="{'dot_blue': index === 0, 'dot_green': index === 1, 'dot_red': index === 2}" :key="index"></i>{{item.label}}
            </template>
            <!-- <i class="dot dot_blue"></i>{{series[0].label}} <i class="dot dot_green" style="margin-left: 0.69rem;"></i>{{series[1].}} -->
        </div>
    </div>
</template>

<script>
import { assertTSIndexedAccessType } from 'babel-types';
const colorMap = ['#00d0c2', '#388cff', '#f9354d'];
export default {
    name: 'm-chart',
    data() {
        return {
            
        }
    },
    props: {
        unit: {
            type: String,
            default: '元/月'
        },
        date: {
            type: Array,
            default: []
        },
        series: {
            type: Array,
            default: []
        }
    },
    methods: {
        init() {
            if(this.date.length == 0 || this.series.length == 0) {
                return;
            }
            let el = this.$refs.iChartItem;
            var myRegression = echarts.init(el);
            var dateLableArr = this.date;

            // var maxVal = Math.max.apply(Math, valArray);
            let series = this.series.map((item, index) => {
                return {
                    name: item.label,
                    data: item.data,
                    type: "line",
                    smooth: true,
                    symbolSize: "5",
                    itemStyle: {
                        normal: {
                            lineStyle: {
                                color: colorMap[index]
                            },
                            color: colorMap[index]
                        }
                    }
                }
            })
            var option = {
                grid: {
                    left: 70,
                    bottom: 25
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
        this.init();
    }
}
</script>

<style scoped>
.m_chart {
    background: #fff;
    position: relative;
}
.m_chart_box {
    /* padding: 0 0.35rem; */
    height:4.7rem; 
    margin: auto;
}
.m_chart_lends {
    font-size: 0.22rem;
    color: #555;
    padding-left: 0.9rem;
    padding-bottom: 0.5rem;
}
.m_chart_unit {
    position: absolute;
    font-size: 0.25rem;
    color: #888;
    top: 0.57rem;
    right: 0.69rem;
    line-height: 0.25rem;
    z-index: 99;
}
</style>


