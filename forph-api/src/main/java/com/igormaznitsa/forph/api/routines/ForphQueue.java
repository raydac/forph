package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.others.IdAware;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import java.util.concurrent.BlockingQueue;

public interface ForphQueue extends IdAware, BlockingQueue<ForphPolyStackItem> {

}
