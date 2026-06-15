import { createBrowserRouter } from 'react-router-dom'
import Login from '../pages/Login'
import MainLayout from '../layouts/MainLayout'
import Home from '../pages/Home'
import Search from '../pages/Search'
import OrgManage from '../pages/OrgManage'
import DeptManage from '../pages/DeptManage'
import EquipManage from '../pages/EquipManage'
import BorrowRecord from '../pages/BorrowRecord'
import MyApply from '../pages/MyApply'
import Notice from '../pages/Notice'
import Feedback from '../pages/Feedback'
import MyTasks from '../pages/MyTasks'
import Profile from '../pages/Profile.jsx'

export const router = createBrowserRouter([
    { path: '/login', element: <Login /> },
    {
        path: '/',
        element: <MainLayout />,
        children: [
            { index: true, element: <Home /> },
            { path: 'home', element: <Home /> },
            { path: 'search', element: <Search /> },
            { path: 'org-manage', element: <OrgManage /> },
            { path: 'dept-manage', element: <DeptManage /> },
            { path: 'equip-manage', element: <EquipManage /> },
            { path: 'borrow-record', element: <BorrowRecord /> },
            { path: 'my-apply', element: <MyApply /> },
            { path: 'notice', element: <Notice /> },
            { path: 'feedback', element: <Feedback /> },
            { path: 'my-tasks', element: <MyTasks /> },
            { path: 'profile', element: <Profile /> },
        ],
    },
])