import React from "react";
import { Tabs } from "expo-router";
import { View, Pressable, Platform } from "react-native";
import { Feather, FontAwesome5, Ionicons, MaterialCommunityIcons } from "@expo/vector-icons";

function CustomTabBar({ state, descriptors, navigation }: any) {
  return (
    <View className="absolute bottom-6 left-5 right-5 h-16 bg-white/95 rounded-full flex-row items-center justify-around px-4 shadow-lg shadow-black/10 border border-gray-100/50 backdrop-blur-md">
      {state.routes.map((route: any, index: number) => {
        const { options } = descriptors[route.key];
        const isFocused = state.index === index;

        const onPress = () => {
          const event = navigation.emit({
            type: "tabPress",
            target: route.key,
            canPreventDefault: true,
          });

          if (!isFocused && !event.defaultPrevented) {
            navigation.navigate({ name: route.name, merge: true });
          }
        };

        const onLongPress = () => {
          navigation.emit({
            type: "tabLongPress",
            target: route.key,
          });
        };

        // Render different icons based on route name
        const renderIcon = () => {
          const color = isFocused ? "#064e3b" : "#1f2937";
          const size = 20;

          const getIcon = () => {
            switch (route.name) {
              case "index":
                return <Feather name="home" size={size} color={color} />;
              case "workout":
                return <FontAwesome5 name="expand-arrows-alt" size={size} color={color} />;
              case "food":
                return <MaterialCommunityIcons name="silverware-fork-knife" size={size} color={color} />;
              case "analytics":
                return <Feather name="trending-up" size={size} color={color} />;
              case "profile":
                return <Feather name="user" size={size} color={color} />;
              default:
                return <Feather name="help-circle" size={size} color={color} />;
            }
          };

          if (isFocused) {
            return (
              <View className="w-12 h-12 bg-emerald-500 rounded-full items-center justify-center shadow-md shadow-emerald-400/30">
                {getIcon()}
              </View>
            );
          }

          return getIcon();
        };

        return (
          <Pressable
            key={route.key}
            accessibilityRole="button"
            accessibilityState={isFocused ? { selected: true } : {}}
            accessibilityLabel={options.tabBarAccessibilityLabel}
            testID={options.tabBarTestID}
            onPress={onPress}
            onLongPress={onLongPress}
            className="items-center justify-center flex-1 h-full"
          >
            {renderIcon()}
          </Pressable>
        );
      })}
    </View>
  );
}

export default function TabLayout() {
  return (
    <Tabs
      tabBar={(props) => <CustomTabBar {...props} />}
      screenOptions={{
        headerShown: false,
      }}
    >
      <Tabs.Screen name="index" options={{ title: "Home" }} />
      <Tabs.Screen name="workout" options={{ title: "Workout" }} />
      <Tabs.Screen name="food" options={{ title: "Food" }} />
      <Tabs.Screen name="analytics" options={{ title: "Analytics" }} />
      <Tabs.Screen name="profile" options={{ title: "Profile" }} />
    </Tabs>
  );
}
