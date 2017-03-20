# FlowTagLayout
Android流式布局，支持点击、单选、多选等，适合用于产品标签等，用法采用Adapter模式，和ListView、GridView用法一样！

使用非常简单，只要你的Adapter实现OnInitSelectedPosition即可，对于点击模式是不存在初始化标签一说的；对于单选模式来说，如果有多个初始化选择，则默认去第一个；对于多选来说正常使用！！！

****

##特色

* 填充数据和ListView、GridView用法一样使用Adapter，更新数据直接通过adapter.notifyDataChanged来更新
* 支持点击、单选、多选事件
* 三种模式：FLOW_TAG_CHECKED_NONE、FLOW_TAG_CHECKED_SINGLE、FLOW_TAG_CHECKED_MULTI
* 支持OnTagClickListener单点事件
* 支持OnTagSelectListener单选、多选事件

****

#效果图

![image](https://github.com/zf101115/mFlowTage/raw/master/mFlowTage/screenshort/flowla.png)



