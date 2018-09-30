<template>
    <div>
        <div ref="chartBox" style="background: #555; width: 100%;height:4.5rem;"></div>
    </div>
</template>

<script>
import iconChartSymbol from 'assets/img/homepage/icon-chart-symbol.png'
import _ from 'lodash';
export default {
  name: "i-chart",
  props: {
    valArr: {
      type: Array,
      default: () => []
    },
    dateArr: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      vals: ["8391.07",null,null,null,null,null],
      date: ["03月", "04月", "05月", "06月", "07月", "08月"]
    };
  },
  methods: {
    init() {
      var myRegression = echarts.init(this.$refs.chartBox);
      // var dateLableArr = this.date.map(d => {
      //   return d !== '' ?  d + "月" : '';
      // });
      var dateLableArr = _.cloneDeep(this.date);
      var valArray = _.cloneDeep(this.vals);
      var maxVal = Math.max.apply(Math, valArray);
      valArray = valArray.map(v => {
        if (v === maxVal) {
          return {
            value: v,
            symbolSize: 16
          };
        }if (v === 0) {
          return {
            value: v,
            symbolSize: 0
          };
        }else {
          return v;
        }
      });
      console.log("valArray", valArray);
      var option = {
        grid: {
          left: -30,
          right: -30,
          bottom: 43
        },
        tooltip: {
          show: true
        },
        xAxis: {
          type: "category",
          data: dateLableArr,
          axisLabel: {
            show: true,
            color: "#fff"
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
          show: true,
          axisLabel: {
            show: false,
            formatter: "{value}k",
            textStyle: {
              color: "#acaeaf"
            }
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
        series: [
          {
            data: valArray,
            label: {
              normal: {
                show: true,
                // position: "top",
                formatter: function(params) {
                  return params.value ? params.value : ''
                },
                textStyle: {
                  color: "#fff"
                }
              }
            },
            type: "line",
            smooth: true,
            symbol: `image://${iconChartSymbol}`,
            symbolSize: "10",
            itemStyle: {
              normal: {
                lineStyle: {
                  width: 0,
                  color: "#fff"
                },
                color: "#fff"
              }
            },
            //渐变
            areaStyle: {
              normal: {
                opacity: 0.4,
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: "#fff"
                  },
                  {
                    offset: 0.4,
                    color: "#fff"
                  },
                  {
                    offset: 1,
                    color: "#4b9af8"
                  }
                ])
              }
            }
          }
        ]
      };
      // 为echarts对象加载数据
      myRegression.setOption(option);
    }
  },
  // computed: {
  //   vals() {
  //     return this.valArray.length > 0 ? _.concat('', this.valArray, '') : []
  //   },
  //   date() {
  //     return this.dateArr.length > 0 ? _.concat(0, this.dateArr, 0) : []
  //   }
  // },
  created() {
    this.vals = _.concat(0, this.valArr, 0)
    this.date = _.concat('', this.dateArr, '')
    // console.log(_.concat(0, this.valArr, 0))
  },
  mounted() {
    this.init();
  }
};
</script>
