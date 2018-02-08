# Purpose

This Project is intended to showcase my skills regarding design and implementation using **MVP design pattern** in Android App Development

# What does this application do
This appliaction connects to a remote backend server using RESTFul services, once the login request is sucess, applicaiton uses WebSockets to connect backend 
and receives list of family members with thie locations. On click of a member takes to map view and drops a pin at member location.

# Whats implemented and how
1. MVP Design pattren 
2. Dagger 2 DI to Inject Network services like Retrofit, WebSocketCilent and application context
3. android.support.v7.widget.RecyclerView, RecyclerView.Adapter with RecyclerView.ViewHolder to show list members 
using static data from member.json file in assets
4. SupportMapFragment to show individual member location on google map

# What needs to done
1. Login needs to done with signed up user 
2. Get list of member of user from backend usuing websockets.
3. Listen to Member location changes using websockets.
4. populate list of members as bottom sheet in mapview 
