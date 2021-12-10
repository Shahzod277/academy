import React from 'react';
import './sidebar.css';
import { LineStyle } from '@material-ui/icons';
import { Analytics } from '@mui/icons-material';

export default function Sidebar() {
    return (
        <div className = "sidebar">
           <div className = "sidebarWrapper">
               <div className = "sidebarMenu">
                   <h3 className = "sidebarTitle">Dashboard</h3>
                   <ul className = "sidebarList">
                       <li className = "sidebarItem active">
                            <LineStyle className = "sidebarIcon"/>
                            Home
                       </li>
                       <li className = "sidebarItem">
                            <Analytics className = "sidebarIcon"/>
                            Analytics
                       </li>
                   </ul>
                   <h3 className = "sidebarTitle">Quick Menu</h3>
                   <ul className = "sidebarList">
                       <li className = "sidebarItem active">
                            <LineStyle className = "sidebarIcon"/>
                            Home
                       </li>
                       <li className = "sidebarItem">
                            <Analytics className = "sidebarIcon"/>
                            Analytics
                       </li>
                   </ul>
               </div>
           </div>
        </div>
    )
}
