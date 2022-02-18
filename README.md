# MVC_RecyclerView

This repository has three branches, each of which demonstrate how a RecyclerView could be updated using MVC pattern.


# branch CustomView

A local dataset is contained in the RecyclerView's CustomAdapter. The local dataset is updated using a CustomView interface.


# branch master

A local dataset is contained in the RecyclerView's CustomAdapter. The local dataset is updated using the Java Observable class and Observer interface.


# branch Observer_ModelOnly

There is no local dataset contained in the RecyclerView's CustomAdapter. The adapter is updated using the Java Observable class and Observer interface, however the data is binded to the adapter by calling model.getInstance().



![alt text](https://github.com/Iyury1/MVC_RecyclerView/blob/main/ProjectUML.drawio.png?raw=true)
