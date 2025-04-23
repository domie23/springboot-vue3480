import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import cangku from '@/views/modules/cangku/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fenkuguanli from '@/views/modules/fenkuguanli/list'
    import news from '@/views/modules/news/list'
    import xianhua from '@/views/modules/xianhua/list'
    import xianhuaChuruInout from '@/views/modules/xianhuaChuruInout/list'
    import xianhuaChuruInoutList from '@/views/modules/xianhuaChuruInoutList/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryCangku from '@/views/modules/dictionaryCangku/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryXianhua from '@/views/modules/dictionaryXianhua/list'
    import dictionaryXianhuaChuruInout from '@/views/modules/dictionaryXianhuaChuruInout/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCangku',
        name: '仓库类型',
        component: dictionaryCangku
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryXianhua',
        name: '货物类型',
        component: dictionaryXianhua
    }
    ,{
        path: '/dictionaryXianhuaChuruInout',
        name: '出入库类型',
        component: dictionaryXianhuaChuruInout
    }


    ,{
        path: '/cangku',
        name: '仓库信息',
        component: cangku
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fenkuguanli',
        name: '分库管理员',
        component: fenkuguanli
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/xianhua',
        name: '货物',
        component: xianhua
      }
    ,{
        path: '/xianhuaChuruInout',
        name: '出入库',
        component: xianhuaChuruInout
      }
    ,{
        path: '/xianhuaChuruInoutList',
        name: '出入库详情',
        component: xianhuaChuruInoutList
      }
    ,{
        path: '/yonghu',
        name: '员工',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
