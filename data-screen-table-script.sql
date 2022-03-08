USE [Children_CareV3]
GO
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (1, N'GET', N'VIEW SETTING FOR ROLES', N'/admin/setting/roles')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (2, N'POST', N'EDIT SETTING FOR ROLES', N'/admin/setting/roles/edit')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (3, N'GET', N'VIEW SETTING FOR USERS', N'/admin/setting/users')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (4, N'PUT', N'EDIT SETTING FOR USERS', N'/admin/api-setting/users')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (5, N'GET', N'VIEW ADMIN SERVICE LIST', N'/admin/services')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (6, N'PUT', N'EDIT SERVICE', N'/admin/api-services')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (7, N'POST', N'ADD SERVICE', N'/admin/api-services')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (8, N'GET', N'VIEW ADMIN DASHBOARD', N'/admin/dashboard')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (9, N'GET', N'VIEW POST MANAGER', N'/manager/post')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (10, N'GET', N'VIEW SLIDER MANAGER', N'/manager/managerView/sliderManager/home')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (11, N'GET', N'VIEW RESERVATION MANAGER', N'/manager/managerView/reservationManager/home')
INSERT [dbo].[screen] ([screen_id], [method], [screen_name], [url]) VALUES (12, N'GET', N'VIEW RESERVATION STAFF', N'/staff/staffView/reservationStaff/home')
GO
