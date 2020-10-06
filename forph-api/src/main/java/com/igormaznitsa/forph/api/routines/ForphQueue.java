package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import java.util.concurrent.BlockingQueue;

public interface ForphQueue extends Nameable, BlockingQueue<ForphPolyStackItem> {

}
