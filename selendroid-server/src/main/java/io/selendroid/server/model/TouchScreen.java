/*
 * Copyright 2011 Selenium committers
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.server.model;


import io.selendroid.server.android.internal.Point;
import io.selendroid.server.common.action.touch.FlickDirection;
import io.selendroid.server.model.interactions.Coordinates;

/**
 * Interface representing basic touch screen operations.
 */
public interface TouchScreen {

  /**
   * Allows the execution of single tap on the screen, analogous to click using a Mouse.
   * 
   * @param where The location on the screen. Typically a {@link WebElement}
   */
  void singleTap(Coordinates where);

  /**
   * Allows the execution of the gesture 'down' on the screen. It is typically the first of a
   * sequence of touch gestures.
   * 
   * @param x The x coordinate relative to the viewport
   * @param y The y coordinate relative to the viewport
   */
  void down(int x, int y);

  void multiTouchDown(int x, int y, int id);

  /**
   * Allows the execution of the gesture 'up' on the screen. It is typically the last of a sequence
   * of touch gestures.
   * 
   * @param x The x coordinate relative to the viewport
   * @param y The y coordinate relative to the viewport
   */
  void up(int x, int y);

  void multiTouchUp(int x, int y, int id);
  /**
   * Allows the execution of the gesture 'move' on the screen.
   * 
   * @param x The x coordinate relative to the viewport
   * @param y The y coordinate relative to the viewport
   */
  void move(int x, int y);

  void multiTouchMove(int x, int y, int id);

  /**
   * Calls 'up' on all current pointers, cancelling the gesture.
   */
  void cancel();

  /**
   * Creates a scroll gesture that starts on a particular screen location.
   * 
   * @param where the location where the scroll starts, usually a {@link WebElement}.
   * @param xOffset The x offset to scroll
   * @param yOffset The y offset to scroll
   */
  void scroll(Coordinates where, int xOffset, int yOffset);

  /**
   * Allows the execution of double tapon the screen, analogous to double click using a Mouse.
   * 
   * @param where The coordinates of the element to double tap
   */
  void doubleTap(Coordinates where);

  /**
   * Allows the execution of long press gestures.
   * 
   * @param where The coordinate of the element to long press
   */
  void longPress(Coordinates where);

  /**
   * Allows the view to be scrolled by an x and y offset.
   * 
   * @param xOffset The horizontal offset relative to the viewport
   * @param yOffset The vertical offset relative to the viewport
   */
  void scroll(int xOffset, int yOffset);

  /**
   * Sends a flick gesture to the current view.
   * 
   * @param xSpeed The horizontal speed in pixels/second
   * @param ySpeed The vertical speed in pixels/second
   */
  void flick(int xSpeed, int ySpeed);

  /**
   * Allows the execution of flick gestures starting in a location's element.
   * 
   * @param where The coordinate of the element to flick on
   * @param xOffset The x offset relative to the viewport
   * @param yOffset The y offset relative to the viewport
   */
  void flick(Coordinates where, int xOffset, int yOffset, int speed);

  /***
   * Allows the execution of a flick gesture at a given starting point
   *
   * @param origin Starting point of the flick
   * @param direction Direction in which the flick should be performed
   * @param distance Distance over which the finger should be down during the flick motion
   * @param duration Duration the finger should be down on the touch screen
   */
  void flick(Point origin, FlickDirection direction, int distance, int duration);

  /**
   * @return The current screen brightness as a float between 0 and 1. If the screen is off, 0.0 will be returned.
   */
  float getBrightness();

  /**
   * Set the screen brightness, with a setting of 0 meaning that the screen should be turned off.
   *
   * @param brightness The screen brightness to use.
   */
  void setBrightness(float brightness);
}
