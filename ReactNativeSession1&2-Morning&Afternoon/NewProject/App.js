/* eslint-disable prettier/prettier */


import React from 'react';
import { View, StyleSheet, Text, SafeAreaView } from 'react-native';
import Footer from './android/Movies/Components/Footer';
import NavBar from './android/Movies/Components/NavBar';

import StackNav from './android/Movies/Components/NavigationStack';
import { NavigationContainer } from '@react-navigation/native';
import SlideDetails from './android/Movies/Components/SlideDetails';
import 'react-native-gesture-handler';
import Slide from './android/Movies/Components/Slide';

{/* <StackNav /> */ }


const App = () => {

  return (
    <>

      <View >
        <NavBar title="My Movies App" />
        <Text>Done By Ravi Theja Kolluru</Text>
      </View>
      <Footer />
      {/* <StackNav /> */}

    </>


  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },

});

export default App;




