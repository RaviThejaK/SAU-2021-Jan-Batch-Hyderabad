/* eslint-disable prettier/prettier */
import React, { } from 'react';
import SlideDetails from './SlideDetails';
import { NavigationContainer } from '@react-navigation/native';
//import Slide from './Slide';
import { createStackNavigator } from '@react-navigation/stack';
import 'react-native-gesture-handler';


const Stack = createStackNavigator();

const StackNav = () => {

    return (
        <NavigationContainer >
            <Stack.Navigator>
                {/* <Stack.Screen name="Slide" component={Slide} /> */}
                <Stack.Screen name="SlideDetails" component={SlideDetails} />

            </Stack.Navigator>
        </NavigationContainer>
    );
};




export default StackNav;
